package club.kegh.threadt.state;


/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月4日
 * @QQ		2641195399
 * @注释
 * 			查看线程的状态
 */
public class ThreadState {

	public static void main(String[] args) {
		
		System.out.println(Thread.State.NEW);				//创建
		System.out.println(Thread.State.RUNNABLE);			//就绪 + 运行
		System.out.println(Thread.State.BLOCKED);			//阻塞
		System.out.println(Thread.State.WAITING);			//wait()/join()
		System.out.println(Thread.State.TIMED_WAITING);		//sleep()/wait(long)/join(long)
		System.out.println(Thread.State.TERMINATED);		//死亡
		
		Thread mainThread = Thread.currentThread();//获取主程序
		
		System.out.println("--------------------------------------------------------------------");
		
		Thread threadAA = new Thread(()->{
			//threadAA线程的状态，为运行状态RUNNABLE
			System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getState());
			
			for (int i = 0; i < 10; i++) {
				try {
					 Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"AA线程");
		
		System.out.println("未调用start之前-->"+threadAA.getState());//new状态，线程刚刚被创建
		threadAA.start();
		
		Thread threadBB = new Thread(()->{
			while(true) {//如果线程AA,则输出它的状态
				if(threadAA.isAlive()) {
					try {
						 Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("BB线程监听AA-->"+threadAA.getState());
				}else {
					System.out.println("BB线程监听AA-->"+threadAA.getState());
					try {
						mainThread.join();				//当AA线程执行完毕后，BB被main阻塞
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		},"BB线程");//线程监听AA的状态
		threadBB.start();
		
		try {
			 Thread.sleep(1200);
				System.out.println("--------------------------------------------------------------------");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B线程的状态-->"+threadBB.getState());
		System.out.println("B线程被阻塞时候，当前线程活跃数-->"+Thread.activeCount());;
	}
}
