package example.concurrent.interrupt;

/**
 * 中断状态下的线程，在抛出InterruptedException异常后，会被重制为非中断状态
 */
public class Main3 {
  public static void main(String[] args) throws InterruptedException {
    Thread c = Thread.currentThread();
    System.out.println("中断状态：" + c.isInterrupted());
    Thread.sleep(1000);
    c.interrupt();
    System.out.println("中断状态：" + c.isInterrupted());
    try {
      Thread.sleep(1000); // 直接抛出异常
    } catch (InterruptedException e) {
      System.out.println("线程被中断，中断状态：" + c.isInterrupted());
    }
  }
}
