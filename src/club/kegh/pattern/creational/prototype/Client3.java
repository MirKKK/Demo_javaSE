package club.kegh.pattern.creational.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.omg.CORBA.portable.OutputStream;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 
 * 			 序列化 和 反序列化
 * 			原型对象深克隆
 */
public class Client3 {
	public static void main(String[] args) {
		try {
			Sheep s1=new Sheep("少利",new Date(4168541654654L));
			
			System.out.println(s1);
			System.out.println(s1.getName());
			System.out.println(s1.getBirthDay());
			
			//开始克隆
			
			
			
			//序列化
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			ObjectOutputStream oo=new ObjectOutputStream(bos);
			oo.writeObject(s1);
			byte[] byteArray = bos.toByteArray();
			
			//反序列化
			ByteArrayInputStream bis=new ByteArrayInputStream(byteArray);
			ObjectInputStream oi=new ObjectInputStream(bis);
			Sheep readObject = (Sheep)oi.readObject();
			
			s1.getBirthDay().setTime(12564413l);
			
			System.out.println("克隆产品.....");
			readObject.setName("多利");
			System.out.println(readObject.getName());
			System.out.println(readObject.getBirthDay());

			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
