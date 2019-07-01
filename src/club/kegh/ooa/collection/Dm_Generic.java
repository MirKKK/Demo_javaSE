package club.kegh.ooa.collection;

import java.util.ArrayList;

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月1日
 * @QQ		2641195399
 * @注释
 * 			泛型  E T K V
 */
public class Dm_Generic {
	
	public static void main(String[] args) {
		 // 这里的”String”就是实际传入的数据类型；
        MyCollection<String> mc = new MyCollection<String>();
        mc.set("aaa", 0);
        mc.set("bbb", 1);
        String str = mc.get(1); //加了泛型，直接返回String类型，不用强制转换;
        System.out.println(str);
	}
	
}


class MyCollection<T>{
	Object[] objs=new Object[5];

	public void set(T object,int index) {
		objs[index] = object;
	}
	
	public T get(int index) {
		return (T)objs[index];
	}
	
}
