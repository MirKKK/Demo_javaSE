package club.kegh.threadt.lambda;

public class Thread_Lambda2 {
	
	//静态内部类
	static class Test1 implements Runnable{
		@Override
		public void run() {
			System.out.println("静态内部类");
		}
	}
	
	
	public static void main(String[] args) {
		//局部内部类
		class Test1 implements Runnable{
			@Override
			public void run() {
				System.out.println("静态内部类");
			}
		}
		
		//匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名内部类");
			}
		}).start();
		
		
		new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("多行没法省略....");
			}
		}) .start();
		
		//Lambda 推导1
		new Thread(()->{
			System.out.println("Lambda 推导1");
		}).start();
		
		//Lambda 推导2
		Runnable t=()->System.out.println("Lambda 推导2");
		new Thread(t).start();
		
		//Lambda 推导3
		new Thread(()->System.out.println("Lambda 推导3")).start();
		
	}

}
