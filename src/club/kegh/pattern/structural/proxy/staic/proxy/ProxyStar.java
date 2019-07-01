package club.kegh.pattern.structural.proxy.staic.proxy;

public class ProxyStar implements Star {

	Star star ;
	
	public ProxyStar(Star star) {
		this.star = star;
	}
	
	
	@Override
	public void confer() {
		System.out.println("proxy-----confer");
	}

	@Override
	public void signContract() {
		System.out.println("proxy-----signContract");
	}

	@Override
	public void bookTicket() {
		System.out.println("proxy-----bookTicket");
	}

	@Override
	public void sing() {
		System.out.println("----------------");
		star.sing();
		System.out.println("****************");
	}

	@Override
	public void collectMoney() {
		System.out.println("proxy-----collectMoney");
	}

}
