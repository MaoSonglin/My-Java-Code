public class SimpleRunnable implements Runnable {
	public void run() { // 覆盖run()方法
		int i = 15;
		while (i-- >= 1) { // 循环15次
			try {
				System.out.print("*");
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Thread thread1 = new Thread(new SimpleRunnable(),"线程1"); // 创建线程1
		thread1.start(); // 启动线程1
	}
}
