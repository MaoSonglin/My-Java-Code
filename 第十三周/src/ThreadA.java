public class ThreadA extends Thread {
	Water water;
	public ThreadA(Water waterArg) {
		water = waterArg;
	}
	public void run() {
		System.out.println("开始进水.....");
		for (int i = 1; i <= 5; i++) {				// 循环5次
			try {
				Thread.sleep(1000);				// 休眠1秒，模拟1分钟的时间
				System.out.println(i + "分钟");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		water.setWater(true);						// 设置水塘有水状态
		System.out.println("进水完毕，水塘水满。");
		synchronized (water) {
			water.notify(); 						// 线程调用notify()方法
		}
	}
}
