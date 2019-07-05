package club.kegh.threadt.demo.unsafe;

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			模拟龟兔赛跑
 */
public class Dm_RunGame_UnSafe implements Runnable {

	public static String winner;// 胜出者

	public static void main(String[] args) {
		Dm_RunGame_UnSafe game=new Dm_RunGame_UnSafe();
		
		new Thread(game,"兔子").start();
		new Thread(game,"乌龟").start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int step = 0; step <= 100; step++) {
			
			System.out.println(Thread.currentThread().getName()+"，走到了-->"+step);
			
			boolean getWinner = isGetWinner(step,Thread.currentThread().getName());
			
			if(getWinner) {
				break;
			}
			
		}
	}
	/**
	 * 	获取胜利者
	 * @param step
	 * @param name
	 * @return
	 */
	public boolean isGetWinner(int step,String name){
		if(winner!=null) {
			return true;
		}else {
			if(step==100) {
				winner=name;
				System.out.println("胜出者："+name);
				return true;
			}
		}
		return false;	
	}
	
}
