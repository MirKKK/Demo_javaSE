package club.kegh.pattern.structural.adapter;

/**
 * 适配器
 * 
 * 两种方式
 * 
 * 1. 使用继承方式
 * 
 * 
 * 2.内部属性调用（组合）
 * 
 *  
 * 
 * 	此类采用方式2
 * 
 * @author Administrator
 *
 */
public class Adapter2  implements Target{
	
	private  Adaptee  adaptee ;
  
	/**
	 * 	构造的时候放进来
	 * @param adaptee
	 */
	public Adapter2(Adaptee  adaptee) {
		this.adaptee=adaptee;
	}
	
	
	@Override
	public void handlerRequest() {
		//开始调用  需要适配的东西
		//因为是父类所以可以直接掉用父类方法
		adaptee.request();
	}
	
}
