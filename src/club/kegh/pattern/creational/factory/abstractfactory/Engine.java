package club.kegh.pattern.creational.factory.abstractfactory;

public interface Engine {
	
	void  start();
	void  run();
	
}


class LuxuryEngine implements Engine{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("启动快......");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("跑的快......");
	}
	
} 



class LowEngine implements Engine{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("启动快......");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("跑的快......");
	}
	
} 