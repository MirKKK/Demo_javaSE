package club.kegh.threadt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释	
 * 			第一个线程类
 */
public class StartThread {

	public static void main(String[] args) {
		// -----------------创建方式一：继承Thread类-----------------
		CreateThread01 thread1_1 = new CreateThread01("thread01_1");// 创建thread1_1的线程
		thread1_1.start();

		CreateThread01 thread1_2 = new CreateThread01("thread01_2");// 创建thread1_2的线程
		thread1_2.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("我是主线程-->" + Thread.currentThread().getName());
		}
		Thread.currentThread().setName("main_use");
		CreateThread01 thread1_3 = new CreateThread01("thread01_3");// 如果启动 则命名为thread1_3
		thread1_3.run();// 后面为什么是main_use呢？ 因为这里没有启动线程，只是调用了普通的run方法（可能不完全在后面 其他线程和主线程同时执行）

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------------------------------------------");

		// -----------------创建方式二：实现Runnable接口-----------------
		// 创建实现类对象
		CreateThread02 thread2 = new CreateThread02();
		// 创建代理类对象
		new Thread(thread2, "thread02_1").start(); // 避免单继承的局限性
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---------------------------------------------------");
		
		// -----------------创建方式三：实现Callable接口-----------------
		//创建
		CreateThread03 thread3=new CreateThread03();
		ExecutorService service=Executors.newFixedThreadPool(3);
		Future<String> submit1 = service.submit(thread3);
		Future<String> submit2 = service.submit(thread3);
		Future<String> submit3 = service.submit(thread3);
		
		try {
			System.out.println(submit1.get());
			System.out.println(submit2.get());
			System.out.println(submit3.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			继承Thread
 */
class CreateThread01 extends Thread {

	public static String threadName;// 不可用

	public CreateThread01() {
	}

	/**
	 * 重写构造方法给线程赋值名字
	 * 
	 * @param threadName
	 */
	public CreateThread01(String threadName) {
//		Thread.currentThread().setName(threadName);//注意不能用这个代码去赋值，Thread.currentThread()在构造的时候是通过main主线程构造的
//		this.threadName=threadName;//注意不能用这个代码去赋值，类变量会被多线程改变
		super(threadName);
	}

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("main_use")) {
			for (int i = 0; i < 5; i++) {
				System.out.println("我还是主线程-->" + Thread.currentThread().getName());
			}
		} else {
			for (int i = 0; i < 5; i++) {
				System.out.println("创建线程By继承Thread类-->" + Thread.currentThread().getName());
			}
		}
	}
}


/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			实现Runnable接口
 */
class CreateThread02 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println("创建线程By实现Runnable接口-->" + Thread.currentThread().getName());
		}
	}
}

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			实现Callable接口.重写call方法
 * 			存在返回值，并且可以抛异常
 */
class CreateThread03 implements Callable<String>{
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println("创建线程By实现Callable接口，重写call方法-->" + Thread.currentThread().getName());
		}
		return "call方法：我有返回值:-->"+Thread.currentThread().getName();
	}
}





