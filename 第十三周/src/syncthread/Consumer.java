package syncthread;

public class Consumer extends Thread {
  private Share shared;//共享资源区
  private int number;
  public Consumer(Share s, int number) {
    shared=s;
    this.number=number;
  }
 public void run() {
    int value = 0;
    for (int i=0; i<10; i++) {
      value=shared.get();//从共享区消费数字
      System.out.println("消费者"+this.number+"  得到的数据为："+value);
    }
  }
}
