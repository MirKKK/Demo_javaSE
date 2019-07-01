package club.kegh.ooa.oo;

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月1日
 * @QQ		2641195399
 * @注释	
 * 			面向对象初解
 */
public class Car {
    //属性（成员变量）
    int id;
    String cname;
    int size;
    
    Car(){//构造方法
    }
    
    //方法
    void run(){
        System.out.println("我正在跑！");
    }  
	
}


// 一个Java文件可以同时定义多个class,但只能有一个public类
class Tyre {
}

class Engine {
}

class Seat {
}
