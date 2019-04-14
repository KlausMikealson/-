package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class container {
  List list = new ArrayList();

   public void add(Object o){
     list.add(o);
   }

   public int size(){
     return list.size();
   }

  public static void main(String[] args) {
     container c = new container();
     Object o = new Object();

    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (o){
          if(c.size()!=5){
            try {
              o.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          o.notify();
        }
        System.out.println("t2结束");
      }
    }, "t2").start();

     new Thread(new Runnable() {
       @Override
       public void run() {
         synchronized (o){
           for(int i=0; i<10; i++){
             c.add(new Object());
             System.out.println("add "+i);
             if(i==5){
               o.notify();
               try {
                 o.wait();
               } catch (InterruptedException e) {
                 e.printStackTrace();
               }
             }
             try {
               TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
               e.printStackTrace();
             }
           }
         }
       }
     }, "t1").start();
  }
}
