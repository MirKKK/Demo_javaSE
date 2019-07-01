package club.kegh.pattern.creational.factory.factormethod;
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			方法工厂模式:（属于开闭原则）
 * 
 *  		优点：
 * 			我们可以增加新的类	和之前代码无关不用改
 *	 		缺点：
 *			 但是增加实体对象， 对应工厂很累赘。
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AoDiFactory aoDiFactory=new AoDiFactory();
		Car createCar = aoDiFactory.createCar();
		createCar.run();
		
		BYDFactory bydFactory =new BYDFactory();
		Car createBYD = bydFactory.createBYD();
		createBYD.run();
		
	}

}
