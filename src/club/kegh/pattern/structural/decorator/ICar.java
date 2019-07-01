package club.kegh.pattern.structural.decorator;


/**
 *  	父接口
 * @author Administrator
 *
 */
public interface ICar {
	public void move();
}


/**
 * 真实对象
 */
class Car implements ICar {
	public void move() {
		System.out.println("汽车移动");
	}
}

/**
 *  Decorator装饰角色
 * @author Administrator
 *
 */
class SuperCar implements ICar{
	private  ICar iCar;
	public SuperCar(ICar iCar) {
		super();
		this.iCar = iCar;
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		iCar.move();
	}
}

class FlyCar extends SuperCar{
	public FlyCar(ICar iCar) {
		super(iCar);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		this.fly();
	}
	
	public void fly() {
		System.out.println("增加****会飞****的情况");
	}
}



/**
 * 	具体装饰角色
 * @author Administrator
 *
 */
class WaterCar extends SuperCar{
	public WaterCar(ICar iCar) {
		super(iCar);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		this.swim();
	}
	
	public void swim() {
		System.out.println("增加****游泳****的情况");
	}
}

class AICar extends SuperCar{
	public AICar(ICar iCar) {
		super(iCar);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
		this.auto();
	}
	
	public void auto() {
		System.out.println("增加****自动****的情况");
	}
}
