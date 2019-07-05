package club.kegh.threadt.demo.safe;

import java.util.concurrent.CopyOnWriteArrayList;

public class Dm_Collection_Safe {
	
	public static void main(String[] args) throws InterruptedException {
		
		CopyOnWriteArrayList<String> list =new CopyOnWriteArrayList<String>();
		
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
