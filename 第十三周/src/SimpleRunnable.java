public class SimpleRunnable implements Runnable {
	public void run() { // ����run()����
		int i = 15;
		while (i-- >= 1) { // ѭ��15��
			try {
				System.out.print("*");
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Thread thread1 = new Thread(new SimpleRunnable(),"�߳�1"); // �����߳�1
		thread1.start(); // �����߳�1
	}
}
