package club.kegh.threadt;

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			实现静态代理，详情请看 club.kegh.pattern.structural.proxy下写的 设计模式--代理模式
 * 			在现成的Runable接口实现时候，用的和这个一样
 */
public class StaicProxy {
	public static void main(String[] args) {

		new ProxyBuyer(new My()).buyHouse();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				
			}
		}).start();
	}
}

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			购买者
 */
interface Buyer{
	public void buyHouse();
}
/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			中介
 */
class ProxyBuyer implements Buyer{

	My my;//代理类对象，代理我
	
	//构造方法
	ProxyBuyer(My my){
		this.my=my;
	}
	
	@Override
	public void buyHouse() {
		
		before();
		//前后可以加处理方法
		my.buyHouse();//我需要买房子，给钱
		//前后可以加处理方法
		after();
		
	}
	
	public void before(){
		System.out.println("销售（代理），帮我看房子...");
		System.out.println("财务（代理），帮公积金贷款...");
	}
	
	
	public void after(){
		System.out.println("售后（代理），帮售后服务");
	}
	
}
/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			买房的我
 */
class My implements Buyer{

	@Override
	public void buyHouse() {
		// TODO Auto-generated method stub
		System.out.println("柯庚宏取钱，并付款。。。。");
	}
	
}


