package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

public class a implements Callable<Integer> {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    a aa = new a();
    FutureTask<Integer> futureTask = new FutureTask<>(aa);
    new Thread(futureTask).start();
    System.out.println(futureTask.get());
  }

  @Override
  public Integer call() throws Exception {
    System.out.println("aaaaaaaaaaa");
    return 1;
  }
}
