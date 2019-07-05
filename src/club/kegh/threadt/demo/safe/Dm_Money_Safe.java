package club.kegh.threadt.demo.safe;

import java.math.BigDecimal;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月5日
 * @QQ		2641195399
 * @注释
 * 			模拟存取钱
 */
public class Dm_Money_Safe {

	public static void main(String[] args) {
		//创建一张银行卡
		SafeAcount acount=new SafeAcount(20000,"商用");
		Thread boy = new Thread(()-> {
			acount.save(1000);
		});
		
		Thread girl = new Thread(()-> {
			acount.draw(2000);
		});
		boy.start();
		girl.start();
		
		//创建一张银行卡
		SafeAcount acount2=new SafeAcount(10000,"家用");
		SafeSave save = new SafeSave(acount2, 20000, "赚钱了");
		SafeDraw draw = new SafeDraw(acount2, 25000, "媳妇花钱了");
		
		save.start();
		draw.start();
	}
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月5日
 * @QQ		2641195399
 * @注释		
 * 			资金账户
 */
class SafeAcount{
	//默认存了10000
	BigDecimal money=new BigDecimal(10000);
	
	//资金用途
	String usage="";
	
	SafeAcount(){}
	
	SafeAcount(double money,String usage){
		this.money=new BigDecimal(money);
		this.usage=usage;
	}
	
	/**
	 * 模拟存钱方法
	 * 			同步方法所对象为当前SafeAcount对象,和draw是同一个锁对象
	 * @param money
	 */
	public synchronized void save(double money) {
		this.money=this.money.add(new BigDecimal(money));
		System.out.println("商用：存款成功,账户余额-->"+this.money.toString());
	}
	/**
	 * 模拟取钱方法
	 * 			同步方法所对象为当前SafeAcount对象,和save是同一个锁对象
	 * @param money
	 */
	public synchronized void draw(double money) {
		this.money=this.money.subtract(new BigDecimal(money));		
		System.out.println("商用：取款成功,账户余额-->"+this.money.toString());
	}
}


/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月5日
 * @QQ		2641195399
 * @注释
 * 			模拟存钱类
 */
class SafeSave extends Thread{
	SafeAcount acount;
	BigDecimal saveCount;
	
	public SafeSave(SafeAcount acount, double saveCount,String name) {
		super(name);		//Thread 父类的方法，给线程命名
		this.acount = acount;
		this.saveCount = new BigDecimal(saveCount);
	}
	
	@Override
	public void run() {
		save();
	}
	
	/**
	 * 注意这个关键字synchronized的锁对象是SafeSave对象,和SafeDraw的draw不是一个对象，不能保障安全
	 */
	public /**synchronized**/ void save() {
		synchronized (acount) {//这回是同一个锁对象。 注意这个锁对象指向不能改变，否则失效
			acount.money=acount.money.add(saveCount);
			System.out.println("家用：存款成功,账户余额-->"+acount.money.toString());
		}
	}
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月5日
 * @QQ		2641195399
 * @注释
 * 			模拟取钱类
 */
class SafeDraw extends Thread{
	SafeAcount acount;
	BigDecimal saveCount;
	
	public SafeDraw(SafeAcount acount, double saveCount,String name) {
		super(name);		//Thread 父类的方法，给线程命名
		this.acount = acount;
		this.saveCount = new BigDecimal(saveCount);
	}
	
	@Override
	public void run() {
		 draw();
	}
	
	/**
	 * 注意这个关键字synchronized的锁对象是SafeDraw对象,和SafeSave的save不是一个对象，不能保障安全
	 */
	public /** synchronized **/ void draw() {
		if(acount.money.doubleValue()<0) {//细节代码，可以提高效率,部分情况直接不去拿锁判断
			return;
		}
		synchronized (acount) {//这回是同一个锁对象。注意这个锁对象指向不能改变，否则失效
			if (acount.money.subtract(saveCount).doubleValue() < 0) {
				System.out.println("家用：取款失败,账户余额-->" + acount.money.toString());
				return;
			}
			acount.money = acount.money.subtract(saveCount);
			System.out.println("家用：取款成功,账户余额-->" + acount.money.toString());
		}
	}
	
}

