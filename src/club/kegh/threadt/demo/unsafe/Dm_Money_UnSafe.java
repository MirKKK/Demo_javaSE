package club.kegh.threadt.demo.unsafe;

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
public class Dm_Money_UnSafe {

	public static void main(String[] args) {
		//创建一张银行卡
		Acount acount=new Acount(20000,"商用");
		Thread boy = new Thread(()-> {
			acount.save(1000);
		});
		
		Thread girl = new Thread(()-> {
			acount.draw(2000);
		});
		boy.start();
		girl.start();
		
		//创建一张银行卡
		Acount acount2=new Acount(10000,"家用");
		Save save = new Save(acount2, 10000, "赚钱了");
		Draw draw = new Draw(acount2, 30000, "媳妇花钱了");
		
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
class Acount{
	//默认存了10000
	BigDecimal money=new BigDecimal(10000);
	
	//资金用途
	String usage="";
	
	Acount(){}
	
	Acount(double money,String usage){
		this.money=new BigDecimal(money);
		this.usage=usage;
	}
	
	/**
	 * 模拟存钱方法
	 * @param money
	 */
	public void save(double money) {
		this.money=this.money.add(new BigDecimal(money));
		System.out.println("商用：存款成功,账户余额-->"+this.money.toString());
	}
	/**
	 * 模拟取钱方法
	 * @param money
	 */
	public void draw(double money) {
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
class Save extends Thread{
	Acount acount;
	BigDecimal saveCount;
	
	public Save(Acount acount, double saveCount,String name) {
		super(name);		//Thread 父类的方法，给线程命名
		this.acount = acount;
		this.saveCount = new BigDecimal(saveCount);
	}
	
	@Override
	public void run() {
		acount.money=acount.money.add(saveCount);
		System.out.println("家用：存款成功,账户余额-->"+acount.money.toString());
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
class Draw extends Thread{
	Acount acount;
	BigDecimal saveCount;
	
	public Draw(Acount acount, double saveCount,String name) {
		super(name);		//Thread 父类的方法，给线程命名
		this.acount = acount;
		this.saveCount = new BigDecimal(saveCount);
	}
	
	@Override
	public void run() {
		acount.money=acount.money.subtract(saveCount);
		if(acount.money.doubleValue()<0) {
			System.out.println("家用：取款失败,账户余额-->"+acount.money.toString());
			return;
		}
		System.out.println("家用：取款成功,账户余额-->"+acount.money.toString());
	}
}

