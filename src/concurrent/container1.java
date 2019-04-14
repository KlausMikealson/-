package concurrent;

import java.util.LinkedList;

public class container1 {
  LinkedList<Object> list = new LinkedList<>();
  int Max = 10;
  int count = 0;

  public synchronized void put(){
    while(count == Max){
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    list.add(new Object());
    System.out.println("生产");
    ++count;
    this.notifyAll();
  }

  public synchronized void get(){
    while(count == 0){
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    list.removeFirst();
    System.out.println("消费");
    --count;
    this.notifyAll();
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
