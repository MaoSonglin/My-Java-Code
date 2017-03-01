public class ThreadB extends Thread {
	Water water;
	public ThreadB(Water waterArg) {
		water = waterArg;
	}
	public void run() {
		System.out.println("启动排水");
		if (water.isEmpty()) {							// 如果水塘无水
			synchronized (water) {						// 同步代码块
				try {
					System.out.println("水塘无水，排水等待中.....");
					water.wait();							// 使线程处于等待状态
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("开始排水.....");
		for (int i = 5; i >= 1; i--) {						// 循环5侧
			try {
				Thread.sleep(1000); 						// 休眠1秒，模拟1分钟
				System.out.println(i + "分钟");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		water.setWater(false);						// 设置水塘无水状态
		System.out.println("排水完毕。");
	}
}
