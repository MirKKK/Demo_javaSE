package club.kegh.pattern.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.tools.FileObject;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			测试安全性(除枚举外都存在  反射和序列化问题)
 */
public class Client2 {

	public static void main(String[] args) {
		System.out.println("----------------------查看不安全性（反射）----------------------");
		try {
			// TODO Auto-generated method stub
			// *--饥汉
			// 静态成员变量
			SingletonDem1_1 s11o1 = SingletonDem1_1.getSingleTon();
			SingletonDem1_1 s11o2 = SingletonDem1_1.getSingleTon();
			System.out.println(s11o1 + "----" + s11o2 + "----" + (s11o1 == s11o2));

			// 破除安全性 -----反射机制获取类对象

			Class<SingletonDem1_1> clazz = (Class<SingletonDem1_1>) Class
					.forName("club.kegh.pattern.creational.singleton.SingletonDem1_1");

			Constructor<SingletonDem1_1> declaredConstructor = clazz.getDeclaredConstructor();
			declaredConstructor.setAccessible(true);// 让方法可达
			SingletonDem1_1 s11o3 = declaredConstructor.newInstance();

			System.out.println("反射机制获取类对象结果："+s11o1 + "----" + s11o3 + "----" + (s11o1 == s11o3));

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("----------------------查看不安全性（序列化）----------------------");
		
		FileOutputStream fo = null;
		ObjectOutputStream oo = null;

		FileInputStream fi = null;
		ObjectInputStream oi = null;
		try {
			// 破除安全性 -----序列化机制获取类对象

			// 静态代码块
			SingletonDem1_2 s12o1 = SingletonDem1_2.getSingleTon();
			SingletonDem1_2 s12o2 = SingletonDem1_2.getSingleTon();
			System.out.println(s12o1 + "----" + s12o2 + "----" + (s12o1 == s12o2));

			
			// 序列化
			fo = new FileOutputStream("F:/single.txt");
			oo = new ObjectOutputStream(fo);
			oo.writeObject(s12o2);
			// 关闭流
			oo.close();
			fo.close();

			// 反序列化
			fi = new FileInputStream("F:/single.txt");
			oi = new ObjectInputStream(fi);
			SingletonDem1_2 s12o3 = (SingletonDem1_2) oi.readObject();
			// 关闭流
			fi.close();
			oi.close();

			System.out.println("序列化机制获取类对象结果："+s12o1 + "----" + s12o3 + "----" + (s12o1 == s12o3));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (oo != null) {
					oo.close();
				}
				if(oi != null) {
					oi.close();
				}
				if(fi != null) {
					fi.close();
				}
				if(fi != null) {
					fi.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("----------------------保障安全性----------------------");
		//破解反序列化
		safety();
	}

	
	/**
	 *	 保证安全性
	 */
	public static void safety() {
		FileOutputStream fo = null;
		ObjectOutputStream oo = null;

		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			// 破除安全性 -----序列化机制获取类对象

			// 静态代码块
			SingletonSafety sso1 = SingletonSafety.getSingleTon();
			SingletonSafety sso2 = SingletonSafety.getSingleTon();
			System.out.println(sso1 + "----" + sso2 + "----" + (sso1 == sso2));

			
			// 序列化
			fo = new FileOutputStream("F:/single.txt");
			oo = new ObjectOutputStream(fo);
			oo.writeObject(sso2);
			// 关闭流
			oo.close();
			fo.close();

			// 反序列化
			fi = new FileInputStream("F:/single.txt");
			oi = new ObjectInputStream(fi);
			SingletonSafety sso3 = (SingletonSafety) oi.readObject();
			// 关闭流
			fi.close();
			oi.close();

			System.out.println("序列化加readResolve()方法："+sso3 + "----" + sso1 + "----" + (sso3 == sso1));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (oo != null) {
					oo.close();
				}
				if(oi != null) {
					oi.close();
				}
				if(fi != null) {
					fi.close();
				}
				if(fi != null) {
					fi.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
