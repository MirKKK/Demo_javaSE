package club.kegh.threadt;

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
		
		//Lambda 推导1
		new Thread(()->{
			System.out.println("Lambda 推导1");
		}).start();
		
		
		//Lambda 推导1
		new Thread(()->{
			System.out.println("Lambda 推导1");
		}).start();
		
		
		
		
	}

}
