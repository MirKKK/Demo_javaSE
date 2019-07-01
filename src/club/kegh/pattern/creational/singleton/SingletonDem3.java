package club.kegh.pattern.creational.singleton;
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 	【不可用】
 * 	懒汉式
 * 	04  双重校验（双重检测锁）
 *  			
 *  		优点：
 * 			 延迟加载，用的时候加载
 *  
 *  		缺点：
 *  		效率低
 * 			（由于JVM底层内部模型原因，极小概率会出问题。不建议使用） 
 */
public class SingletonDem3 {
	/**
	 * 	私有化构造函数
	 */
	private SingletonDem3() {
	};

	private static /* final/volatile */  SingletonDem3 s;// 类初始化就加载

	/**
	 * 	同步方法 （线程不安全的）synchronized
	 * 	资源利用率可能高了
	 *	方法同步调用效率低             每次调用getSingleTon()方法都要同步，效率较低。
	 * 	
	 * @return
	 */
	public static SingletonDem3 getSingleTon() {
		if (s == null) {
			synchronized (SingletonDem3.class) {
				if (s == null) {
					s = new SingletonDem3();
				}
			}
		}
		return s;
	}
}
