package example.concurrent.future;

import java.util.concurrent.*;

public class Main2 {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService exe = Executors.newFixedThreadPool(5);
    Future<String> f = exe.submit(new Callable<String>() {
      public String call() throws Exception {
        Thread.sleep(4000);
        return "ok";
      }
    });
    Thread.sleep(3000);
    try {
      System.out.println(f.get(3, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } catch (TimeoutException e) {
      f.cancel(true);
    } catch (ExecutionException e) {
      // 处理异常
    }
  }

}
