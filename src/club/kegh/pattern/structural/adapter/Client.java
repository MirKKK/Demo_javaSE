package club.kegh.pattern.structural.adapter;

public class Client {

	/**
	 * 
	 * target相当于
	 * 	电脑的usb接口    或者  对应原版插头
	 * @param target
	 */
	public static void oneMethod(Target target) {
		target.handlerRequest();
	}
	
	
	public static void main(String[] args) {
		//被适配对象
		Adaptee adaptee=new Adaptee();

		//类适配器方式,继承不灵活
		Adapter adapter=new Adapter();
		
		//对象组合方式
		Adapter2 adapter2=new Adapter2(adaptee);
		
		Client.oneMethod(adapter);
		Client.oneMethod(adapter2);
		
	}

}
