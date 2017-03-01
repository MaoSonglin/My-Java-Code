package syncthread;

public class Producer extends Thread {
  private Share shared;//共享资源区
  private int number;
  public Producer(Share s, int number) {
    shared=s;
    this.number=number;
  }
 public void run() {
    for (int i=0; i<10; i++) {
      shared.put(i);//生产数字放入共享区
      System.out.println("生产者"+this.number+"  输出的数据为："+i);
      try {
        sleep((int)(Math.random() * 100));//休眠随机时间
      } catch (InterruptedException e) {}
    }
  }
}
