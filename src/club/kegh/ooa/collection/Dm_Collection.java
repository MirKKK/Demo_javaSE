package club.kegh.ooa.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月1日
 * @QQ		2641195399
 * @注释
 * 			Collection接口中的方法
 */
public class Dm_Collection {
	public static void main(String[] args) {
		Collection<String> coll= new ArrayList<>();
		
		coll.add("AA");
		coll.add("BB");
		coll.add("CC");
		coll.add("11");
		coll.add("22");
		coll.add("33");
		
		//常用方法
		System.out.println("remove:"+coll.remove("CC"));
		System.out.println("size:"+coll.size());
		System.out.println("isEmpty:"+coll.isEmpty());
		System.out.println("contains:"+coll.contains("AA"));
		
		Object[] array = coll.toArray();
		System.out.println("toArray:"+Arrays.toString(array));
		
		Collection<String> coll2= new ArrayList<>();
		coll2.add("11");
		coll2.add("22");
		coll2.add("33");
		
		System.out.println("removeAll:"+coll.removeAll(coll2)+"--"+coll);//去除两者交集
		
		System.out.println("addAll:"+coll.addAll(coll2)+"--"+coll);//添加所有
		
		System.out.println("retainAll:"+coll.retainAll(coll2)); //取交集
		
		System.out.println("retainAll:"+coll.containsAll(coll2)); //是否全部包含
		
		coll.clear();//无返回值
		System.out.println("clear:"+coll);
		
	}
}
