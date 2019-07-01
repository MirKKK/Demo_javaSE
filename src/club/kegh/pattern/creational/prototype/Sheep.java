package club.kegh.pattern.creational.prototype;

import java.io.Serializable;
import java.util.Date;

public class Sheep implements Cloneable,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Date birthDay;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
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

	public Sheep(String name, Date birthDay) {
		super();
		this.name = name;
		this.birthDay = birthDay;
	}

}
