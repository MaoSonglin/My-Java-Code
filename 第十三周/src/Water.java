public class Water {
	boolean water = false;							// ��Ӧˮ��״̬�ı���
	public boolean isEmpty() {							// �ж�ˮ���Ƿ���ˮ�ķ���
		return water ? false : true;
	}
	public void setWater(boolean haveWater) {			// ����ˮ��״̬�ķ���
		this.water = haveWater;
	}
	public static void main(String[] args) {
		Water water=new Water();						// ����ˮ������
		ThreadA threadA = new ThreadA(water);			// ������ˮ�߳�
		ThreadB threadB = new ThreadB(water);			// ������ˮ�߳�
		threadB.start();								// ������ˮ�߳�
		threadA.start();								// ������ˮ�߳�
	}
}
