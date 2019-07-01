package club.kegh.pattern.creational.builder;


/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			实现构建
 */
public class SelfAirShipBuilder implements AirShipBuilder {

	@Override
	public Engine buildEngine() {
		System.out.println("构建自己的发动机....");
		
		//可以通过		工厂模式，单例模式	 结合
		return new Engine("self发动机");
	}

	@Override
	public OrbitalModule buildOrbitalModule() {
		System.out.println("构建自己的轨道舱....");
		return new OrbitalModule("self轨道舱");
	}

	@Override
	public EscapeTower buildEscapeTower() {
		System.out.println("构建自己的逃逸塔....");
		return new EscapeTower("self逃逸塔");
	}

}
