package club.kegh.pattern.creational.singleton;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			各种方式创建单例
 * 
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//  *--饥汉
		// 静态成员变量
		SingletonDem1_1 s11o1 = SingletonDem1_1.getSingleTon();
		SingletonDem1_1 s11o2 = SingletonDem1_1.getSingleTon();
		System.out.println(s11o1 + "----" + s11o2 + "----" + (s11o1 == s11o2));
		// 静态代码块
		SingletonDem1_2 s12o1 = SingletonDem1_2.getSingleTon();
		SingletonDem1_2 s12o2 = SingletonDem1_2.getSingleTon();
		System.out.println(s12o1 + "----" + s12o2 + "----" + (s12o1 == s12o2));

		// *--懒汉
		// 线程不安全
		SingletonDem2_1 s21o1 = SingletonDem2_1.getSingleTon();
		SingletonDem2_1 s21o2 = SingletonDem2_1.getSingleTon();
		System.out.println(s21o1 + "----" + s21o2 + "----" + (s21o1 == s21o2));
		// 同步方法
		SingletonDem2_2 s22o1 = SingletonDem2_2.getSingleTon();
		SingletonDem2_2 s22o2 = SingletonDem2_2.getSingleTon();
		System.out.println(s22o1 + "----" + s22o2 + "----" + (s22o1 == s22o2));
		// 同步代码款
		SingletonDem2_3 s23o1 = SingletonDem2_3.getSingleTon();
		SingletonDem2_3 s23o2 = SingletonDem2_3.getSingleTon();
		System.out.println(s23o1 + "----" + s23o2 + "----" + (s23o1 == s23o2));

		// 双重校验
		SingletonDem3 s3o1 = SingletonDem3.getSingleTon();
		SingletonDem3 s3o2 = SingletonDem3.getSingleTon();
		System.out.println(s3o1 + "----" + s3o2 + "----" + (s3o1 == s3o2));
		
		// *--静态内部类
		SingletonDem4 s4o1 = SingletonDem4.getSingleTon();
		SingletonDem4 s4o2 = SingletonDem4.getSingleTon();
		System.out.println(s4o1 + "----" + s4o2 + "----" + (s4o1 == s4o2));
		
		// *--枚举
		SingletonDem5 s5o1=SingletonDem5.INSTANCE;
		SingletonDem5 s5o2=SingletonDem5.INSTANCE;
		System.out.println(s5o1 + "----" + s5o2 + "----" + (s5o1 == s5o2));
	}

}
