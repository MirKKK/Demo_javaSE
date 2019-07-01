package club.kegh.pattern.creational.prototype;

import java.util.Date;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 
 * 			System.out.println(clone.getBirthDay());
 */
public class Client2 {
	public static void main(String[] args) {
		try {
			Sheep2 s1=new Sheep2("少利",new Date(4168541654654L));
			
			System.out.println(s1);
			System.out.println(s1.getName());
			System.out.println(s1.getBirthDay());
			
			//开始克隆
			Sheep2 clone = (Sheep2)s1.clone();
			
			System.out.println("---克隆的产品，测试3--");
			
			//更改原先的日期---------影响
			s1.getBirthDay().setTime(56465465441L);

			System.out.println(clone);
			System.out.println(clone.getName());
			System.out.println(clone.getBirthDay());

			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
