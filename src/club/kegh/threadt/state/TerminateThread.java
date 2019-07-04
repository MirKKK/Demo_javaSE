package club.kegh.threadt.state;
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			终止线程
 * 			1、线程自己执行完毕
 * 			2、外部干涉
 * 			3、掉用stop和 destroy方法-----不建议
 */
public class TerminateThread implements Runnable {

	private boolean flag = true;

	public static void main(String[] args) throws InterruptedException {
		TerminateThread thread =new TerminateThread();
		new Thread(thread,"柯柯").start();

		Thread.sleep(20);

		thread.terminate();
	}

	@Override
	public void run() {
		int i=0;
		while (flag) {
			System.out.println(Thread.currentThread().getName()+"我在跑酷........请求终止：step="+i++);
		}

	}

	/**
	 * 终止进程
	 */
	public  void  terminate() {
		flag = false;
	}

}
