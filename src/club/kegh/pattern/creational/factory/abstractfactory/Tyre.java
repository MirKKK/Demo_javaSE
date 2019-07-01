package club.kegh.pattern.creational.factory.abstractfactory;

public interface Tyre {
	
	void  revole();
	
}


class LuxuryTyre implements Tyre{

	@Override
	public void revole() {
		// TODO Auto-generated method stub
		System.out.println("转速快......");
	}
	
} 



class LowTyre implements Tyre{
	@Override
	public void revole() {
		// TODO Auto-generated method stub
		System.out.println("转速慢......");

	}
} 