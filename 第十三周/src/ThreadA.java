public class ThreadA extends Thread {
	Water water;
	public ThreadA(Water waterArg) {
		water = waterArg;
	}
	public void run() {
		System.out.println("��ʼ��ˮ.....");
		for (int i = 1; i <= 5; i++) {				// ѭ��5��
			try {
				Thread.sleep(1000);				// ����1�룬ģ��1���ӵ�ʱ��
				System.out.println(i + "����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		water.setWater(true);						// ����ˮ����ˮ״̬
		System.out.println("��ˮ��ϣ�ˮ��ˮ����");
		synchronized (water) {
			water.notify(); 						// �̵߳���notify()����
		}
	}
}
