package club.kegh.pattern.structural.proxy.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{

	Star realStar;
	
	public StarHandler(Star realStar) {
		super();
		this.realStar=realStar;
	}
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object =null;
		
		System.out.println("做些事情1");
		System.out.println("做些事情2");
		
		if(method.getName().equals("sing")) {
			object =method.invoke(realStar, args);
		}
		
		System.out.println("做些事情3");
		System.out.println("做些事情4");
		/*
		 * 
		 * System.out.println("----------------"); method.invoke(realStar, args);
		 * System.out.println("****************");
		 */

		return null;
	}
	
	
}
