public class SyncThread extends Thread {
	private char cha;
	public SyncThread(char cha) { 						// 构造函数
		this.cha = cha;
	}
	public void run() {
		PrintClass.printch(cha); 						// 调用同步方法
		System.out.println();
	}
	public static void main(String[] args) {
		SyncThread t1 = new SyncThread('A'); 			// 创建线程A
		SyncThread t2 = new SyncThread('B'); 			// 创建线程B
		t1.start(); 									// 启动线程A
		t2.start(); 									// 启动线程B
	}
}
class PrintClass {
	public static synchronized void printch(char cha) { // 同步方法
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);					// 打印一个字符休息1秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(cha);
		}
	}
}
