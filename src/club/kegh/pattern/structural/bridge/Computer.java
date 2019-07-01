package club.kegh.pattern.structural.bridge;

public interface Computer {
	void sale();
}

/**
 * 	台式
 * @author Administrator
 *
 */
class Desktop implements Computer{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售台式机");
	}
	
}
/**
 * 	笔记本
 * @author Administrator
 *
 */
class Laptop implements Computer{

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售台式机");
	}
	
}
/**
 * 	平板
 * @author Administrator
 *
 */
class Pad implements Computer{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售平板");
	}
}

/*
 * class LenovoDesktop extends Desktop{
 * 
 * @Override public void sale() { // TODO Auto-generated method stub
 * System.out.println("销售台式机"); }
 * 
 * }
 * 
 * class LenovoLaptop extends Laptop{
 * 
 * @Override public void sale() { // TODO Auto-generated method stub
 * System.out.println("销售台式机"); }
 * 
 * }
 * 
 * class LenovoPad extends Pad{
 * 
 * @Override public void sale() { // TODO Auto-generated method stub
 * System.out.println("销售台式机"); } }
 */


