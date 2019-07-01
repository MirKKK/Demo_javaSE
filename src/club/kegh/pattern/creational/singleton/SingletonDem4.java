package club.kegh.pattern.creational.singleton;
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 	【可用】
 * 	静态内部类
 *  		优点：
 * 			 延迟加载，用的时候加载
 * 			资源利用率高，效率高
 *  
 *  		缺点：
 *  			
 */
public class SingletonDem4 {
	/**
	 * 	私有化构造函数 
	 */
	private SingletonDem4(){};
	
	/**
	 * 	静态内部类
	 * 	延迟加载，用的时候加载
	 */
	private static class SingletonInner{
		private static /*final*/ SingletonDem4 INSTANCE = new SingletonDem4();
	}
	
	
	/**
	 * 	 资源利用率高了，同时延迟加载
	 * 	
	 * @return
	 */
	public static SingletonDem4 getSingleTon() {
		return SingletonInner.INSTANCE;
	}
}
