package example.concurrent.interrupt;

/**
 * thread.interrupt()方法将线程设置为中断状态
 */
public class Main {
  public static void main(String[] args) {
    Thread c = Thread.currentThread();
    System.out.println(c.isInterrupted());
    c.interrupt();
    System.out.println(c.isInterrupted());
  }
}
