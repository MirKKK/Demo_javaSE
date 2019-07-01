package club.kegh.pattern.structural.composite;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFile a1,a2,a3,b1,b2,b3;
		Folder f1,f2,f3;
		a1=new ImageFile("美女.jpg");
		a2=new ImageFile("帅哥.jpg");
		a3=new TextFile("不良儿童列表.txt");
		
		b1=new ImageFile("青山.jpg");
		b2=new ImageFile("白云.jpg");
		b3=new TextFile("优秀儿童列表.txt");
		
		f1 =new Folder("少儿不宜");
		f1.add(a1).add(a2).add(a3);
		
		f2 =new Folder("少儿很宜");
		f2.add(b1).add(b2).add(b3);
		
		f3 = new Folder("资料");
		f3.add(f1).add(f2);
		
		
		f3.killVirus();
	}
}
