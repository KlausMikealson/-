package concurrent;

public class a {
  public synchronized void m1(){
    System.out.println(Thread.currentThread().getName()+" is start.");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName()+" is end.");
  }

  public void m2(){
    System.out.println(Thread.currentThread().getName()+" is start.");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName()+" is end.");
  }

  public static void main(String[] args) {
    a aa = new a();
    /*new Thread(()->aa.m1(), "m1").start();
    new Thread(()->aa.m2(), "m2").start();*/

    new Thread(aa::m1, "m1").start();
    new Thread(aa::m2, "m2").start();
  }
}
