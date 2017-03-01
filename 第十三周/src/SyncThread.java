public class SyncThread extends Thread {
	private char cha;
	public SyncThread(char cha) { 						// ���캯��
		this.cha = cha;
	}
	public void run() {
		PrintClass.printch(cha); 						// ����ͬ������
		System.out.println();
	}
	public static void main(String[] args) {
		SyncThread t1 = new SyncThread('A'); 			// �����߳�A
		SyncThread t2 = new SyncThread('B'); 			// �����߳�B
		t1.start(); 									// �����߳�A
		t2.start(); 									// �����߳�B
	}
}
class PrintClass {
	public static synchronized void printch(char cha) { // ͬ������
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);					// ��ӡһ���ַ���Ϣ1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(cha);
		}
	}
}
