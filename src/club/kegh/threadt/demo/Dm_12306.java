package club.kegh.threadt.demo;


/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			模拟抢票出现的问题
 */
public class Dm_12306 implements Runnable {

	public static int tickets = 100;

	@Override
	public void run() {

		while (true) {
			// 模拟延迟
			if (tickets < 0) {
				break;
			}

			// 必须放到判断的后面
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + "抢到了一张-->余票：" + tickets--);
		}

	}

	public static void main(String[] args) {
		// 一份资源
		Dm_12306 d1 = new Dm_12306();
		// 多个代理
		new Thread(d1, "小K").start();
		new Thread(d1, "老柯").start();
		new Thread(d1, "MM").start();

	}
}

