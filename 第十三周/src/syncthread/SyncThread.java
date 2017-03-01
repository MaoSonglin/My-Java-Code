package syncthread;
public class SyncThread extends Thread {
	private String cha;
	public SyncThread(String cha) { 				// 构造函数
		this.cha = cha;
	}
	public void run() {
		PrintClass.printch(cha);					// 调用同步方法
	}
	public static void main(String[] args) {
		SyncThread t1 = new SyncThread("线程A"); 	// 创建线程A
		SyncThread t2 = new SyncThread("线程B"); 	// 创建线程B
		t1.start(); 								// 启动线程A
		t2.start(); 								// 启动线程B
	}
}
class PrintClass {
	static Object printer = new Object(); 			// 实例化Object对象
	public static void printch(String cha) { 		// 同步方法
		synchronized (printer) { 					// 同步块
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
