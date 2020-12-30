package example.concurrent.interrupt;

/**
 * 父线程被设置为中断状态，不会将子线程也设置为中断状态
 */
public class Main4 {
  public static void main(String[] args) throws InterruptedException {
    Thread parent = Thread.currentThread();
    Thread child = new Thread(new Runnable() {
      public void run() {
        System.out.println("子线程运行中");
        try {
          Thread.sleep(60000);
        } catch (InterruptedException e) {
          System.out.println("子线程被中断");
        }
      }
    });
    child.start();
    parent.interrupt();
    System.out.println("父线程被设置为中断状态");
    for (int i = 0; i < 1000000000; i++) {
    }
    System.out.println("父线程结束");
  }
}
