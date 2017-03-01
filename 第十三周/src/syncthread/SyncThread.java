package syncthread;
public class SyncThread extends Thread {
	private String cha;
	public SyncThread(String cha) { 				// ���캯��
		this.cha = cha;
	}
	public void run() {
		PrintClass.printch(cha);					// ����ͬ������
	}
	public static void main(String[] args) {
		SyncThread t1 = new SyncThread("�߳�A"); 	// �����߳�A
		SyncThread t2 = new SyncThread("�߳�B"); 	// �����߳�B
		t1.start(); 								// �����߳�A
		t2.start(); 								// �����߳�B
	}
}
class PrintClass {
	static Object printer = new Object(); 			// ʵ����Object����
	public static void printch(String cha) { 		// ͬ������
		synchronized (printer) { 					// ͬ����
			for (int i = 1; i < 5; i++) {
				System.out.println(cha + " ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
