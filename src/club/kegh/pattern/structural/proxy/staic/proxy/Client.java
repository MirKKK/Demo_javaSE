package club.kegh.pattern.structural.proxy.staic.proxy;

public class Client {
	public static void main(String[] args) {
		RealStar real=new RealStar();
		
		ProxyStar proxy=new ProxyStar(real);
		
		//使用的是代理的方法
		proxy.bookTicket();
		
		//使用真实对象的方法，可在这里进行操作
		proxy.sing();
		
	}
}
