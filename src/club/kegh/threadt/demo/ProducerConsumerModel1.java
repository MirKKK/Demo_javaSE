package club.kegh.threadt.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月6日
 * @QQ		2641195399
 * @注释	
 * 			生产者消费者模型---管程法
 */
public class ProducerConsumerModel1 {
	
	public static void main(String[] args) {
		Repository repository = new Repository(5);
		
		Thread productor = new Thread(new Productor(repository));
		Thread consumer = new Thread(new Consumer(repository));
		
		productor.start();
		consumer.start();
	}
	
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月6日
 * @QQ		2641195399
 * @注释
 * 			生产者
 */
class Productor implements Runnable{
	private Repository res;

	public Productor(Repository res) {
		super();
		this.res = res;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Product product = new Product("鞋子"+i,(new Random().nextInt(10)+35)+"",new Random().nextDouble()*200+200);
			res.push(product);
		}		
	}
	
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月6日
 * @QQ		2641195399
 * @注释
 * 			消费者
 */
class Consumer implements Runnable {
	private Repository res;

	public Consumer(Repository res) {
		super();
		this.res = res;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res.pop();
		}
	}

}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月6日
 * @QQ		2641195399
 * @注释
 * 			仓库，缓冲区
 */
class Repository{
	Product[] pros;//仓库容量100
	
	Integer count=0; //计数器
	
	public Repository() {
		pros=new Product[100];
	}
	
	public  Repository(int cnum) {
		this.pros =new Product[cnum];
	}

	/**
	 * 存方法
	 * @param p
	 * @throws InterruptedException 
	 */
	public synchronized void push(Product p)  {
		if(count>=pros.length){
			System.out.println("仓库已经满了，不能生产了............");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pros[count]=p;
		count++;
		this.notifyAll();
		System.out.println("生产了产品："+p.toString());
	}
	
	/**
	 * 取方法
	 * @return
	 * @throws InterruptedException 
	 */
	public synchronized Product pop() {
		if(count<1){
			System.out.println("仓库已经空了，不能出售了............");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Product p=pros[count-1];//我从头开始消费注意下
		count--;
		System.out.println("卖出了产品："+p.toString());
		this.notifyAll();
		return p;
	}
	
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月6日
 * @QQ		2641195399
 * @注释
 * 			某产品
 */
class Product{
	private String name;
	private String size;
	private double price;
	
	
	
	public Product(String name, String size, double price) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", size=" + size + ", price=" + price + "]";
	}
	
}