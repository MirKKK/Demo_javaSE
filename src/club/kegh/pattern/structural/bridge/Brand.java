package club.kegh.pattern.structural.bridge;

public interface Brand {
	void sale();
}

class Lenovo implements Brand {
	public void sale() { // TODO Auto-generated method stub
		System.out.print("销售联想机");
	}
}

class Dell implements Brand {
	public void sale() { // TODO Auto-generated method stub
		System.out.print("销售Dell机");
	}
}