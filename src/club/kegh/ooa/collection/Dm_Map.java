package club.kegh.ooa.collection;

import java.util.HashMap;
import java.util.Map;

public class Dm_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String>  m1 = new HashMap<>();
		
		m1.put(1, "AA");
		m1.put(2, "BB");
		m1.put(3, "CC");
		
		System.out.println(m1.get(1)); 
		
		System.out.println(m1.size()); 
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("CC"));
		
		Map<Integer,String> m2 = new HashMap<>();
		m2.put(4, "DD");
		m2.put(5, "EE");
		
		m1.putAll(m2);		//增加所有元素
		System.out.println(m1);
		
		//map中键不能重复！如果重复(是否重复是根据equals方法来判断)，则新的覆盖旧的！
		m1.put(3, "三");
		System.out.println(m1);
	}

}
