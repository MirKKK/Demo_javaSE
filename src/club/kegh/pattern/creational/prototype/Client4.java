package club.kegh.pattern.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import org.omg.CORBA.portable.OutputStream;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 
 * 
 * 			耗时对比
 */
public class Client4 {
	public static void main(String[] args) {
		
		ByteArrayOutputStream bo=null;
		ObjectOutputStream oo=null;
		try {
			Laptop prototypeLaptop = new Laptop("电脑--序号:");
			
			//实现序列化 ----→到直接数组
			bo=new ByteArrayOutputStream();
			oo=new ObjectOutputStream(bo);
			oo.writeObject(prototypeLaptop);
			oo.close();
			bo.close();
			
			byte[] byteArray = bo.toByteArray();
			
			long startTime = System.currentTimeMillis();

			int count = 10;
			CountDownLatch countDownLatch = new CountDownLatch(count);

			for (int j = 0; j < count; j++) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < 100; i++) {
//							 testNew();
							 
							 //给进去原型
//							 testClone(prototypeLaptop);
							 
							 testSerialize(byteArray);
							 
						}
						countDownLatch.countDown();
					}
				}).start();
			}

			countDownLatch.await();

			long enbTime = System.currentTimeMillis();
			
			System.out.println("总耗时："+(enbTime-startTime));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(oo!=null) {
					oo.close();
				}
				if(bo!=null) {
					bo.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	
	/**
	 * new方式clone
	 * 10s
	 */
	public static void testNew() {
		UUID randomUUID = UUID.randomUUID();
		//耗时 10秒
		new Laptop("电脑--序号:" + randomUUID + "");
	}
	
	
	/**
	 * Clone方法克隆 时0.167
	 * @param byteArray
	 */
	public static void testClone(Laptop prototypeLaptop) {
		try {
			UUID randomUUID = UUID.randomUUID();
			
			Laptop laptopClone = (Laptop)prototypeLaptop.clone();
			
			//耗时0.167
			laptopClone.setName(laptopClone.getName()+randomUUID);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
/**
 * 序列化方式克隆 0.269s
 * @param byteArray
 */
public static void testSerialize(byte[] byteArray) {
		ByteArrayInputStream bi=null;
		ObjectInputStream oi=null;
	
		try {
			UUID randomUUID = UUID.randomUUID();
			
			bi=new ByteArrayInputStream(byteArray);
			oi=new ObjectInputStream(bi);
			Laptop laptopClone = (Laptop)oi.readObject();
			oi.close();
			bi.close();
			
			laptopClone.setName(laptopClone.getName()+randomUUID);
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(oi!=null) {
					oi.close();
				}
				if(bi!=null) {
					bi.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
	}
	
}

class Laptop implements Cloneable,Serializable {

	private String name;

	public Laptop(String name) {

		try {
			// 创建时长
			Thread.sleep(100);

			this.name = name;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
