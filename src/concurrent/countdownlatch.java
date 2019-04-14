package concurrent;

import concurrent.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class countdownlatch {
  List list = new ArrayList();

  public void add(Object o){
    list.add(o);
  }

  public int size(){
    return list.size();
  }

  public static void main(String[] args) {
    container c = new container();
    CountDownLatch countDownLatch = new CountDownLatch(1);

    new Thread(new Runnable() {
      @Override
      public void run() {
          if(c.size()!=5){
            try {
              countDownLatch.await();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        System.out.println("t2结束");
      }
    }, "t2").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
          for(int i=0; i<10; i++){
            c.add(new Object());
            System.out.println("add "+i);
            if(i==5){
              countDownLatch.countDown();
            }
            try {
              TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
    }, "t1").start();
  }
}
