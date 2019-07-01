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
 * 	02  同步方法
 *  			
 *  		优点：
 * 			 延迟加载，用的时候加载
 *  
 *  		缺点：
 *  		效率低
 * 			同时线程不安全（概率较小但是也会发生）
 */
public class SingletonDem2_2 {
	/**
	 *	 私有化构造函数 
	 */
	private SingletonDem2_2(){};
	
	private static /*final*/ SingletonDem2_2 s ;//类初始化就加载
	
	/**
	 * 	同步方法 （线程不安全的）synchronized
	 * 	资源利用率可能高了
	 * 	方法同步调用效率低             每次调用getSingleTon()方法都要同步，效率较低。
	 * 	
	 * @return
	 */
	public static synchronized SingletonDem2_2 getSingleTon() {
		if(s==null) {
			s = new SingletonDem2_2();
		}
		return s;
	}
}
