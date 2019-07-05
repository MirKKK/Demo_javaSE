package club.kegh.threadt.demo.unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Dm_Collection_UnSafe {
	
	public static void main(String[] args) throws InterruptedException {
		
		List<String> list =new ArrayList<String>();
		
		for (int i = 0; i < 10000; i++) {
			new Thread(()-> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		
		while (true) {
			if(Thread.activeCount()==1) {
				System.out.println(list.size());//这里执行完的数量不对，少加了
				return;
			}
		}
		
	}
	
}
