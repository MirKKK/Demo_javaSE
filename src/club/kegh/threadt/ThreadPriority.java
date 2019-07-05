package club.kegh.threadt;

public class ThreadPriority {

	public static void main(String[] args) {
		// 线程的默认优先级
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		
		//设置线程优先级,不保证先后概率，只保证优先概率
		MyThread myThread =new MyThread();
		
		Thread t1=new Thread(myThread,"t1");
		Thread t2=new Thread(myThread,"t2");
		Thread t3=new Thread(myThread,"t3");
		Thread t4=new Thread(myThread,"t4");
		Thread t5=new Thread(myThread,"t5");
		Thread t6=new Thread(myThread,"t6");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		t4.setPriority(6);
		t5.setPriority(7);
		t6.setPriority(8);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
	
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月4日
 * @QQ		2641195399
 * @注释
 * 
 * 			自定义线程
 */
class MyThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		}
	}
}
