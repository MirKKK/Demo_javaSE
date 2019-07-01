package club.kegh.pattern.creational.factory.simplefactory;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			简单工厂：违反开闭原则，但我们经常使用
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarFactory carFactory = new CarFactory();
		
		Car createCar = carFactory.createCar("奥迪");
		createCar.run();
		
		Car createCar2 = carFactory.createCar("BYD");
		createCar2.run();
		
		
		CarFactory2 carFactory2 = new CarFactory2();
		Car createAoDi = carFactory2.createAoDi();
		createAoDi.run();
		
		Car createBYD = carFactory2.createBYD();
		createBYD.run();
		
	}

}
