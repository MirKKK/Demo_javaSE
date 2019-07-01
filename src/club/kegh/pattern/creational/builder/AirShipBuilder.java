package club.kegh.pattern.creational.builder;

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 */
public interface AirShipBuilder {
	Engine buildEngine();
	OrbitalModule buildOrbitalModule();
	EscapeTower buildEscapeTower();
}
