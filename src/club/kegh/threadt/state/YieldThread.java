package club.kegh.threadt.state;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			线程礼让，sleep是暂停不释放锁，属于阻塞状态
 * 			yield属于释放资源，让其他线程处于就绪状态
 * 
 */
public class YieldThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestYieldThread thread1_1=new TestYieldThread();
		
		new Thread(thread1_1,"AA").start();
		new Thread(thread1_1,"阿斯蒂芬").start();
		
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("--------------测试2--------------(其实并看不出结果，和正常执行类似)");
		//使用lambda
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("我是"+Thread.currentThread().getName()+"---"+i);
				if(i%10==0) {
					Thread.yield();
				}
			}
		},"BB").start();
		
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("我是"+Thread.currentThread().getName()+"---"+i);
			}
		},"范德萨").start();
		
	}

}

class TestYieldThread implements Runnable{

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()+"-->start");
		
		Thread.yield();//这里的礼让，只是释放资源，然后让当前线程处于就绪状态，所以CPU可能再次抢到这个的执行权
		
		//放大问题
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"-->end");
		
	}
	
}
