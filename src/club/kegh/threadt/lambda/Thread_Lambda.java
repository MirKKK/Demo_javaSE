package club.kegh.threadt.lambda;

public class Thread_Lambda {
	
	//静态内部类
	static class Like implements iLike{
		@Override
		public String study(String status, String method) {
			System.out.println("静态内部类......");
			return status+method;
		}
	}
	
	
	public static void main(String[] args) {
		
//		Thread_Lambda.Like; 只能调用静态方法
		
		//局部内部类
		class Like implements iLike{
			@Override
			public String study(String status, String method) {
				return status+","+method;
			}
		}
		iLike like=new Like();
		System.out.println(like.study("局部内部类", "创建并调用study方法"));
		
		//匿名内部类
		like = new Like() {
			@Override
			public String study(String status, String method) {
				return status+","+method;
			}
		};
		System.out.println(like.study("匿名内部类", "调用study方法"));
		
		
		//Lambda 推导1
		like = (status,method)->{
			return status+","+method;
		};
		System.out.println(like.study("Lambda 推导1", "必须要有类型，否则报错"));
		
		

		//Lambda 推导2
		like = (status,method)->status+","+method;
		System.out.println(like.study("Lambda 推导2", "一行代码的话可以省略很多"));
		
		
		//Lambda 推导3   如果一个参数可以省略()
		iLike2 like2 = status->status;
		
	}
	
	
	interface iLike{
		public String study(String status,String method);
//		public String study(String status);   必须只有一个方法
	}

	
	interface iLike2{
		public String study(String status);
//		public String study(String status);   必须只有一个方法
	}
}
