package club.kegh.pattern.creational.builder;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			实现组装
 */
public class SelfAirShipDirector implements AirShipDirector {

	
	private AirShipBuilder airShipBuilder;

	
	public SelfAirShipDirector(AirShipBuilder airShipBuilder) {
		super();
		this.airShipBuilder = airShipBuilder;
	}

	@Override
	public AirShip directAirShip() {
		Engine engine=airShipBuilder.buildEngine();
		EscapeTower orbitalModule = airShipBuilder.buildEscapeTower();
		OrbitalModule escapeTower = airShipBuilder.buildOrbitalModule();
		
		AirShip airShip=new AirShip(orbitalModule, engine, escapeTower);
		
		return airShip;
	}



}
