public class Water {
	boolean water = false;							// 反应水塘状态的变量
	public boolean isEmpty() {							// 判断水塘是否无水的方法
		return water ? false : true;
	}
	public void setWater(boolean haveWater) {			// 更改水塘状态的方法
		this.water = haveWater;
	}
	public static void main(String[] args) {
		Water water=new Water();						// 创建水塘对象
		ThreadA threadA = new ThreadA(water);			// 创建进水线程
		ThreadB threadB = new ThreadB(water);			// 创建排水线程
		threadB.start();								// 启动排水线程
		threadA.start();								// 启动进水线程
	}
}
