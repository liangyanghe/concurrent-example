package example.concurrent.future;

import java.util.concurrent.*;

public class Main {

  public static void main(String[] args) {
    ExecutorService exe = Executors.newSingleThreadExecutor();
    Future<String> f = exe.submit(new Callable<String>() {
      public String call() throws Exception {
        Thread.sleep(60000);
        return "ok";
      }
    });
    try {
      f.get(3, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } catch (TimeoutException e) {
      f.cancel(true);
    } catch (ExecutionException e) {
      // 处理异常
    }
  }

}
