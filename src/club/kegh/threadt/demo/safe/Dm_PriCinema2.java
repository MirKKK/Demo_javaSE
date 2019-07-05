package club.kegh.threadt.demo.safe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月5日
 * @QQ		2641195399
 * @注释
 * 			购票人,使用代理
 */
class Proxy extends Thread{
	List<Integer> needSeats;	//需要座位
	
	Proxy(String name,List<Integer> needSeats,Runnable target){
		super(target,name);//这个相当于new Thread(new Runnable);
		this.needSeats=needSeats;
	}
}
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月5日
 * @QQ		2641195399
 * @注释
 * 			私人影院-----通过影院中来加锁，使用同步方法
 * 			使用了代理模式
 */
public class Dm_PriCinema2 implements Runnable {

	List<Integer> seats; // 座位

	Dm_PriCinema2(List<Integer> seats) {
		this.seats = seats;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		bookTickets();
	}

	/**
	 * 购票方法
	 */
	public synchronized void bookTickets() {
		// 获取影院的所有位置
		List<Integer> allSeats = this.seats;

		Proxy p = (Proxy) Thread.currentThread();

		boolean containsAll = allSeats.containsAll(p.needSeats);

		// 如果包含所有座位
		if (containsAll) {
			allSeats.removeAll(p.needSeats);
			System.out.println(Thread.currentThread().getName() + "-->订票成功-->余票：" + allSeats.toString());
		} else {
			List<Integer> copyNeedSeats = new ArrayList<Integer>(p.needSeats);

			copyNeedSeats.retainAll(allSeats);

			p.needSeats.removeAll(copyNeedSeats);

			System.out.println(Thread.currentThread().getName() + "-->订票失败-->以下票没了：" + p.needSeats.toString());
		}
	}
	
	public static void main(String[] args) {
		List<Integer> seats =new ArrayList<Integer>();
		//一排
		seats.add(12);
		seats.add(13);
		seats.add(14);
		seats.add(15);
		seats.add(16);
		//二排
		seats.add(22);
		seats.add(23);
		seats.add(24);
		seats.add(25);
		seats.add(26);
		Dm_PriCinema2 dm_PriCinema2 = new Dm_PriCinema2(seats);//创建一个影院
		
		//第一个需要的座位
		List<Integer> needSeats1 =new ArrayList<Integer>();
		needSeats1.add(12);
		needSeats1.add(13);
		needSeats1.add(14);
		needSeats1.add(15);
		needSeats1.add(16);
		Proxy proxy1 = new Proxy("小柯", needSeats1 , dm_PriCinema2);
		proxy1.start();
		
		//第二个需要的座位
		List<Integer> needSeats2 =new ArrayList<Integer>();
		needSeats2.add(12);
		needSeats2.add(13);
		//创建一个客户：小美同学
		Proxy proxy2 = new Proxy("小美同学", needSeats2,dm_PriCinema2);
		proxy2.start();
	}

}




