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
 * 			 实现深复制
 */
public class Sheep2 implements Cloneable {// 多利
	private String name;
	private Date birthDay;

	/**
	 * 	深复制解决方案
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object object=super.clone();
		Sheep2 s=(Sheep2)object;
		s.birthDay=(Date) this.birthDay.clone();
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Sheep2(String name, Date birthDay) {
		super();
		this.name = name;
		this.birthDay = birthDay;
	}

}
