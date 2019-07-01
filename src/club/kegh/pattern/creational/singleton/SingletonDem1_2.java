package club.kegh.pattern.creational.singleton;

import java.io.Serializable;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 	【可用】
 * 	 饥（饿）汉式        
 * 	02  静态代码块
 *  		优点：
 * 			 速度最快，天然线程安全
 *  
 *  		缺点：
 * 			不管用不用，先创建起来再说
 *			如果只是加载本类，而不是要调用getInstance()，甚至永远没有调用，则会造成资源浪费！
 * 
 */
public class SingletonDem1_2  implements Serializable{
	/**
	 * 	私有化构造函数 
	 */
	private SingletonDem1_2(){};
	
	private static SingletonDem1_2 s;
	
	/**
	 * 	类初始化时，自动加载对象（没有延迟加载的优势）。
	 *	天然线程安全，调用效率高
	 */
	 static
	 {
		 s =new SingletonDem1_2();//类初始化就加载
	 }
	
	/**
	 * 	方法没有同步调用效率更高
	 * 	饿汉式单例模式代码中，static变量会在类装载时初始化，此时也不会涉及多个线程对象访问该对象的问 题。
	 * 	虚拟机保证只会装载一次该类，肯定不会发生并发访问的问题。因此，可以省略synchronized关键字。
	 * @return
	 */
	public static /* synchronized */ SingletonDem1_2 getSingleTon() {
		return s;
	}

}
