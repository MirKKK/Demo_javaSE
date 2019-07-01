package club.kegh.pattern.structural.decorator;

public class Client {
	public static void main(String[] args) {
		//首先有被加强的对象存在
		Car car=new Car();
		
		FlyCar flyCar=new FlyCar(car);
		flyCar.move();
		
		FlyCar flyAICar=new FlyCar(new AICar(car));
		flyAICar.move();
		
		FlyCar flyAIWaterCar=new FlyCar(new AICar(new WaterCar(car)));
		flyAIWaterCar.move();
		
		
		
	}
}
