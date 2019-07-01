package club.kegh.pattern.creational.factory.simplefactory;

public class CarFactory2 {

	public Car createAoDi() {
		return new AoDi();
	}
	
	public Car createBYD() {
		return new BYD();
	}
	
}
