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
 * 			原型模式潜复制
 */
public class Client {
	public static void main(String[] args) {
		try {
			Sheep s1=new Sheep("少利",new Date(4168541654654L));
			
			System.out.println(s1);
			System.out.println(s1.getName());
			System.out.println(s1.getBirthDay());
			
			//开始克隆
			Sheep clone = (Sheep)s1.clone();
			
			System.out.println("---克隆的产品，测试2---");
			
			//更改原先的日期---------影响
			s1.getBirthDay().setTime(56465465441L);
			System.out.println(clone);
			System.out.println(clone.getName());
			System.out.println(clone.getBirthDay());
			
			
			//更改原先的日期指针指向-----不影响   
			s1.setBirthDay(new Date(146541514635L));
			System.out.println("---克隆的产品，测试1--");
			clone.setName("多利");
			System.out.println(clone);
			System.out.println(clone.getName());
			System.out.println(clone.getBirthDay());
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
