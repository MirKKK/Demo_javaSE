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
 * 	01  线程不安全  不加锁
 *  			
 *  		优点：
 * 			 延迟加载，用的时候加载
 *  
 *  		缺点：
 * 			线程不安全
 */
public class SingletonDem2_1 {
	/**
	 * 	私有化构造函数 
	 */
	private SingletonDem2_1(){};
	
	private static /*final*/ SingletonDem2_1 s ;
	
	/**
	 * 	延迟加载，用的时候加载
	 * 	
	 * @return
	 */
	public static synchronized SingletonDem2_1 getSingleTon() {
		if(s==null) {
			s = new SingletonDem2_1();
		}
		return s;
	}
}
