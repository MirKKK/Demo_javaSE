package club.kegh.pattern.creational.singleton;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

import javax.tools.FileObject;



/**
 * 	测试效率
 *  
 * 
 * @author Administrator
 *
 */
public class Client3 {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();

		int threadNum=1000;//计数
		CountDownLatch countDownLatch=new CountDownLatch(threadNum);
		
		for(int j=0;j<threadNum;j++) {
			
			new Thread(new Runnable() {
				public void run() {
					for(int i=0;i<1000000l;i++) {
						SingletonDem3 s = SingletonDem3.getSingleTon();
					}
					//-1
					countDownLatch.countDown();
				}
			}).start();
			
		}
		
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
	}
}
