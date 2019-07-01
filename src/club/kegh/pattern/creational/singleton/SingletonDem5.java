package club.kegh.pattern.creational.singleton;
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 	【可用】
 * 	枚举类型
 *  		优点：
 * 			 枚举本身就是单例模式。由JVM从根本上提供保障！避免通过反射和反序列化的漏洞！ （其他都有）
 * 				
 */
public enum SingletonDem5 {
	
	INSTANCE;

	public static void whaterver() {
		System.out.println("随意方法处理...");
	}
	
}
