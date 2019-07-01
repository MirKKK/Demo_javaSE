package club.kegh.pattern.creational.builder;
/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			飞船
 */
public class AirShip {
	
	private OrbitalModule  orbitalModule;
	
	private Engine engine;
	
	private EscapeTower escapeTower;
	
	/*
	 * 	构造方法1
	 */
	public AirShip(OrbitalModule orbitalModule, Engine engine, EscapeTower escapeTower) {
		this.orbitalModule = orbitalModule;
		this.engine = engine;
		this.escapeTower = escapeTower;
	}
	/*
	 * 	构造方法2
	 */
	public AirShip(EscapeTower escapeTower2, Engine engine2,OrbitalModule  orbitalModule2) {
		this.orbitalModule = orbitalModule2;
		this.engine = engine2;
		this.escapeTower = escapeTower2;
	}
	

	public OrbitalModule getOrbitalModule() {
		return orbitalModule;
	}

	public void setOrbitalModule(OrbitalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public EscapeTower getEscapeTower() {
		return escapeTower;
	}

	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}

	public void launch() {
		this.orbitalModule.before();
		this.engine.run();
		this.escapeTower.drop();
		System.out.println("发射");
	}
	
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			 轨道舱
 */
class OrbitalModule{
	
	private String name;
	
	public OrbitalModule(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void before() {
		System.out.println("准备轨道舱....");
	}
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			 发动机
 */
class Engine{
	private String name;
	
	public Engine(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println("启动引擎....");
	}
	
}

/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年6月27日
 * @QQ		2641195399
 * @注释
 * 			 逃逸塔
 */
class EscapeTower{
	private String name;
	
	public EscapeTower(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void drop() {
		System.out.println("扔掉逃逸塔....");
	}
}
