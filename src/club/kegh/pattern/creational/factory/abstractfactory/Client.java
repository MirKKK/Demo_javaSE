package club.kegh.pattern.creational.factory.abstractfactory;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 
 * 			抽象工厂：（针对一个产品族进行创建）
 */
public class Client {
   
	public static void main(String[] args) {
		CarFactory carFactory =new LuxuryCarFactory();
		Engine en = carFactory.createEngine();
		en.start();
		en.run();
		
		carFactory.createSeat();
		carFactory.createTyre();
	   
   }
   
}
