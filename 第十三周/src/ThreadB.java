public class ThreadB extends Thread {
	Water water;
	public ThreadB(Water waterArg) {
		water = waterArg;
	}
	public void run() {
		System.out.println("������ˮ");
		if (water.isEmpty()) {							// ���ˮ����ˮ
			synchronized (water) {						// ͬ�������
				try {
					System.out.println("ˮ����ˮ����ˮ�ȴ���.....");
					water.wait();							// ʹ�̴߳��ڵȴ�״̬
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("��ʼ��ˮ.....");
		for (int i = 5; i >= 1; i--) {						// ѭ��5��
			try {
				Thread.sleep(1000); 						// ����1�룬ģ��1����
				System.out.println(i + "����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		water.setWater(false);						// ����ˮ����ˮ״̬
		System.out.println("��ˮ��ϡ�");
	}
}
