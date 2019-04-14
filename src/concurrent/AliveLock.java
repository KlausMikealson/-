package concurrent;

public class AliveLock {
  Object a = new Object();
  Object b = new Object();

  public void method1(){
    synchronized (a){
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (b){
        System.out.println("method1");
      }
    }
  }

  public void method2(){
    synchronized (b){
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (a){
        System.out.println("method2");
      }
    }
  }

  public static void main(String[] args) {
    AliveLock aliveLock = new AliveLock();
    new Thread(aliveLock::method1, "thread1").start();
    new Thread(aliveLock::method2, "thread2").start();
  }
}
