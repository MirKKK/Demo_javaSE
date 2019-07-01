package club.kegh.pattern.structural.adapter;

/**
 * 适配器
 * 
 * 两种方式
 * 
 * 1. 使用继承方式
 * 
 * 
 * 2.内部属性调用
 * 
 * 
 * 此类采用方式1
 * 
 * @author Administrator
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handlerRequest() {
		//开始调用  需要适配的东西
		//因为是父类所以可以直接掉用父类方法
		super.request();
	}
	
}
