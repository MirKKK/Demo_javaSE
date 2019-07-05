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
 * 			私人影院-----容器的安全操作
 */
public class Dm_PriCinema {

	List<Integer> seats;	//座位
	
	Dm_PriCinema(List<Integer> seats){
		this.seats=seats;
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
		Dm_PriCinema dm_PriCinema = new Dm_PriCinema(seats);//创建一个影院
		
		//第一个需要的座位
		List<Integer> needSeats1 =new ArrayList<Integer>();
		needSeats1.add(12);
		needSeats1.add(13);
		needSeats1.add(14);
		needSeats1.add(15);
		needSeats1.add(16);
		//创建一个客户：小柯同学
		Client client = new Client(dm_PriCinema,"小柯同学", needSeats1);
		client.start();
		
		//第二个需要的座位
		List<Integer> needSeats2 =new ArrayList<Integer>();
		needSeats2.add(12);
		needSeats2.add(13);
		//创建一个客户：小美同学
		Client client2 = new Client(dm_PriCinema,"小美同学", needSeats2);
		client2.start();
	}
}
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月5日
 * @QQ		2641195399
 * @注释
 * 			购票人
 */
class Client extends Thread{
	Dm_PriCinema cinema;
	
	List<Integer> needSeats;	//需要座位
	
	Client(Dm_PriCinema cinema,String name,List<Integer> needSeats){
		super(name);
		this.cinema=cinema;
		this.needSeats=needSeats;
	}
	
	@Override
	public void run() {
		bookTickets();
	}
	
	/**
	 * 购票方法
	 */
	public void bookTickets(){
		synchronized(cinema){
			//获取影院的所有位置
			List<Integer> allSeats = cinema.seats;
			
			boolean containsAll = allSeats.containsAll(needSeats);
			
			//如果包含所有座位
			if(containsAll) {
				allSeats.removeAll(needSeats);
				System.out.println(Thread.currentThread().getName()+"-->订票成功-->余票："+allSeats.toString());
			}else {
				List<Integer> copyNeedSeats=new ArrayList<Integer>(needSeats);
				
//				Collections.copy(copyNeedSeats,needSeats);//Source does not fit in dest
				
				copyNeedSeats.retainAll(allSeats);
				
				needSeats.removeAll(copyNeedSeats);
				
				System.out.println(Thread.currentThread().getName()+"-->订票失败-->以下票没了："+needSeats.toString());
			}
		}
	}
	
}


