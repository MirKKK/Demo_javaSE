package club.kegh.pattern.structural.bridge;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Brand b=new Brand() {
				@Override
				public void sale() {
					// TODO Auto-generated method stub
					System.out.println("销售匿名品牌....");
				}
			};
		
			Computer2 c=new Computer2(new Lenovo());
			c.sale();
			
			Computer2 c2=new Desktop2(new Lenovo());
			c2.sale();

	}

}
