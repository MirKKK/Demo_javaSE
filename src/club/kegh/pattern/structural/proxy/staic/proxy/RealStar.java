package club.kegh.pattern.structural.proxy.staic.proxy;

public class RealStar implements Star {

	@Override
	public void confer() {
		System.out.println("real-----confer");
	}

	@Override
	public void signContract() {
		System.out.println("real-----signContract");
	}

	@Override
	public void bookTicket() {
		System.out.println("real-----bookTicket");
	}

	@Override
	public void sing() {
		System.out.println("real-----sing");
	}

	@Override
	public void collectMoney() {
		System.out.println("real-----collectMoney");
	}

}
