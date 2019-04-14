package concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ticket {
  static Queue<String> tickets = new ConcurrentLinkedQueue<String>();

  static {
    for(int i=0; i<100; i++){
      tickets.add("id: "+i);
    }
  }

  public static void main(String[] args) {
    for(int i=0; i<10; i++){
      new Thread(()->{
        while(true){
          String s = tickets.poll();
          if(s == null)
            break;
          else{
            System.out.println(s);
          }
        }
      }).start();
    }
  }
}
