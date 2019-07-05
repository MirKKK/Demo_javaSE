package club.kegh.threadt;

public class DaemonThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread you = new Thread(new You());
		Thread god = new Thread(new God());
		
		god.setDaemon(true);
		
		you.start();
		god.start();
	}

}

class You implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<365*100;i++) {
			System.out.println("-----------------------做我喜欢做的事情。。。。。。");
		}
		
	}
	
}

class God implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("守护着你。。。。。。");
		}
	}
	
}