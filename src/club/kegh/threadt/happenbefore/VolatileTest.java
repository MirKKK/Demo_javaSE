package club.kegh.threadt.happenbefore;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月6日
 * @QQ		2641195399
 * @注释
 * 			
 */
public class VolatileTest {

	static /**volatile**/ int num=0;
	
	public static void main(String[] args) throws InterruptedException {

		new Thread(()->{
			while(num==0) {//此处不能写代码，让cpu不能去检查后续对num的操作
				
			}
		}).start();
		
		Thread.sleep(1000);
		
		num=1;
	}

}
