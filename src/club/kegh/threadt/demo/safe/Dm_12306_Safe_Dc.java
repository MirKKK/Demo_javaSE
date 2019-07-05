package club.kegh.threadt.demo.safe;


/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			模拟抢票,线程安全，doublecheck双重检测
 */
public class Dm_12306_Safe_Dc implements Runnable {

	public static int tickets = 1000;//总票

	@Override
	public void run() {

		while (true) {//这个while一定不能放到同步方法里面，加上while后，这个锁可就不能释放了，就被一个人一直占用着
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//不加sleep，其他线程也能抢到。加了后分配均匀效果明显
			rob();
		}

	}

	private void rob() {
		if (tickets <= 0) {//针对没票情况
			return;
		}
		synchronized(this) {//这里不能用tickets（假如为Integer）：因为这个对象的指针变了，锁了一个变得对象，还是不安全
			// 模拟延迟
			if (tickets <= 0) {//针对1张票的情况
				return;
			}
			// 必须放到判断的后面
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到了一张-->余票：" + tickets--);
		}
	}
	
	
	public static void main(String[] args) {
		// 一份资源
		Dm_12306_Safe_Dc d1 = new Dm_12306_Safe_Dc();
		// 多个代理
		new Thread(d1, "小K").start();
		new Thread(d1, "老柯").start();
		new Thread(d1, "MM").start();
	}
}

