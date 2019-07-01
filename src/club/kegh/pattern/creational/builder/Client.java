package club.kegh.pattern.creational.builder;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建
		AirShipBuilder airShipBuilder =new SelfAirShipBuilder();
		
		//组装
		AirShipDirector airShipDirector =new SelfAirShipDirector(airShipBuilder);
		
		//获取
		AirShip directAirShip = airShipDirector.directAirShip();
		
		System.out.println(directAirShip.getEngine().getName());
		
		directAirShip.launch();
	}

}
