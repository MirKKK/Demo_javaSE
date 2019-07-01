
package club.kegh.pattern.creational.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			比较判断
 * 
 */
public class SingletonSafety implements Serializable{
	/**
	 * ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 私有化构造函数
	 */
	private SingletonSafety() {
	};

	/**
	 * 
	 * 延迟加载，用的时候加载
	 */
	private static SingletonSafety s;// 类初始化就加载

	/**
	 * 同步方法 （线程不安全的）synchronized 资源利用率可能高了 方法同步调用效率低 每次调用getInstance()方法都要同步，效率较低。
	 * 
	 * @return
	 */
	public static SingletonSafety getSingleTon() {
		if (s == null) {
			synchronized (SingletonDem3.class) {
				if (s == null) {
					s = new SingletonSafety();
				}
			}
		}
		return s;
	}

	//对应writeReplace,解决了序列化安全问题
	private Object readResolve() throws ObjectStreamException{
		return s;
	} 
	
}
