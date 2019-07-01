package club.kegh.pattern.creational.factory.abstractfactory;

public interface Seat {
	
	void  massage();
	
}


class LuxurySeat implements Seat{

	@Override
	public void massage() {
		// TODO Auto-generated method stub
		System.out.println("舒服......");

	}
	
} 



class LowSeat implements Seat{

	@Override
	public void massage() {
		// TODO Auto-generated method stub
		System.out.println("不舒服......");

	}
	
} 