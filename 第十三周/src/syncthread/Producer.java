package syncthread;

public class Producer extends Thread {
  private Share shared;//������Դ��
  private int number;
  public Producer(Share s, int number) {
    shared=s;
    this.number=number;
  }
 public void run() {
    for (int i=0; i<10; i++) {
      shared.put(i);//�������ַ��빲����
      System.out.println("������"+this.number+"  ���������Ϊ��"+i);
      try {
        sleep((int)(Math.random() * 100));//�������ʱ��
      } catch (InterruptedException e) {}
    }
  }
}
