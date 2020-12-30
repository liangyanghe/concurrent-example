package example.concurrent.interrupt;

/**
 * 中断状态下的线程，在执行sleep，wait等会抛出InterruptedException的方法时，会抛出异常
 */
public class Main2 {
  public static void main(String[] args) throws InterruptedException {
    Thread c = Thread.currentThread();
    System.out.println(c.isInterrupted());
    Thread.sleep(1000);
    c.interrupt();
    System.out.println(c.isInterrupted());
    Thread.sleep(1000); // 直接抛出异常
  }
}
