package club.kegh.threadt.state;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			join方法
 * 			插队，插入    时间完 也是 进入就绪
 */
public class JoinThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread main = Thread.currentThread();
		
		Thread t = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "---》" + i);
				if(i%30==0) {
					try {
						
						main.join(1);	//插队t线程被阻塞
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"线程A");
		t.start();
		
		//主线程
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + "---》" + i);
		}
		
		
		
		System.out.println("--------------测试2--------------");
		new Thread(() -> {
				System.out.println(Thread.currentThread().getName() +":准备做饭.......");
				System.out.println(Thread.currentThread().getName() +"：没有原材料，需要柯柯出去买......");
				
				Thread thread = new Thread(() -> {
					System.out.println(Thread.currentThread().getName()+"：那我出去买原材料.........");
					try {
						Thread.sleep(6000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"：原材料买回来了.....哈哈！");
				},"柯柯");
				thread.start();//开始去买了
				try {
					thread.join(); //买不回来没法做饭啊
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				System.out.println(Thread.currentThread().getName() +"：原材料........有了，可以做饭了.");
		
		},"女朋友").start();
		
		
		
	}

}
