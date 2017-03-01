public class SimpleThread extends Thread {
	public SimpleThread(String name) {		// 参数为线程名称
		setName(name);
	}
	public void run() {		// 覆盖run()方法
		int i = 0;
		while (i++ < 5) { 		// 循环5次
			try {
				System.out.println(getName() + "执行步骤" + i);
				Thread.sleep(1000); 	// 休眠1秒
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		SimpleThread thread1 = new SimpleThread("线程1"); 	// 创建线程1
		SimpleThread thread2 = new SimpleThread("线程2"); 	// 创建线程2
		thread1.start(); 									// 启动线程1
		thread2.start();                                    // 启动线程2
	}
}
