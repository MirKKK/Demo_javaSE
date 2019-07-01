package club.kegh.pattern.creational.factory.simplefactory;

public class CarFactory {

	public Car createCar(String carName) {
		
		Car car=null;
		
		if(carName.equals("奥迪")) {
			car=new AoDi();
		}else if(carName.equals("BYD")){
			car=new BYD();
		}
		
		return car;
	}
	
}
