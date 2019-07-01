package club.kegh.pattern.structural.adapter;

/**
 * 需要适配的东西  比如说键盘     比如说插头
 * @author Administrator
 *
 */
public class Adaptee {
		
	public void request() {
		System.out.println("完成客户需要的功能");
	}
	
}
