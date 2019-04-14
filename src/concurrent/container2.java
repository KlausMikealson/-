package concurrent;

import concurrent.container1;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class container2 {
  LinkedList<Object> list = new LinkedList<>();
  int Max = 10;
  int count = 0;
  Lock lock = new ReentrantLock();
  Condition producer = lock.newCondition();
  Condition consumer = lock.newCondition();

  public void put(){
    try{
      lock.lock();
      while(count == Max){
        producer.await();
      }
      list.add(new Object());
      System.out.println("生产");
      ++count;
      consumer.signalAll();
    }catch(InterruptedException e){
      e.printStackTrace();
    }finally {
      lock.unlock();
    }
  }

  public void get(){
    try{
      lock.lock();
      while(count == 0){
        consumer.await();
        list.removeFirst();
        --count;
        producer.signalAll();
      }
    }catch (InterruptedException e){
      e.printStackTrace();
    }finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    container1 c = new container1();

    for(int i=0; i<10; i++){
      new Thread(c::get, "consumer").start();
    }

    for(int i=0; i<11; i++){
      new Thread(c::put, "producer").start();
    }
  }


}
