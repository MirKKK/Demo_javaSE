package club.kegh.pattern.structural.bridge;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Computer2 {
	protected Brand brand;
	
	public Computer2(Brand brand) {
		this.brand=brand;
	}
	
	public void sale() {
		brand.sale();
		System.out.println();
	}
}


class Desktop2 extends Computer2{

	public Desktop2(Brand brand) {
		super(brand);
	}
	
	public void sale() {
		brand.sale();
		System.out.println("台式机");
	}
}

class Laptop2 extends Computer2{

	public Laptop2(Brand brand) {
		super(brand);
	}
	
	public void sale() {
		brand.sale();
		System.out.println("笔记本");
	}
}