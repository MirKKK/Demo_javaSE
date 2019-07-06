package club.kegh.threadt.happenbefore;

/**
 * 指令重排: 代码执行顺序与预期不一致
 * 目的:提高性能
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class HappenBefore {
	// 变量1
	private static int a = 1;
	// 变量2
	private static boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			a = 1;
			flag = false;

			// 线程1 更改数据
			Thread t1 = new Thread(() -> {
				a = Integer.MAX_VALUE/Integer.MAX_VALUE+Integer.valueOf(1);//放大开销，其实a=2;
				flag = true;
			});
			// 线程2 读取数据
			Thread t2 = new Thread(() -> {
				//此线程不会重排序
				if (flag) {
					a = a * a; 	//如果flag为true:按理a是2，返回4
								//其实可能 	flag = true;先执行  a还没赋值是1
				}
				
				if (a == 1) {// 指令重排时等于1
					System.out.println("happen before a->" + a); //a=2其实cpu返回时间差
				}
				
				
			});

			t1.start();
			t2.start();

			// 合并线程，让其先执行完，然后再执行主线程
			t1.join();
			t2.join();
		}
	}

}
