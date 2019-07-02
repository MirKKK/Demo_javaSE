package club.kegh.ooa.collection;

import java.util.ArrayList;
/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月2日
 * @QQ		2641195399
 * @注释
 * 			List的方法
 */
public class Dm_List {
	public static void main(String[] args) {
		ArrayList<String> coll = new ArrayList<>();
		coll.add("AA");
		coll.add("BB");
		coll.add("CC");
		coll.add("DD");
		coll.add(2, "kgh"); // 重载add index要小于总长度 否则:java.lang.IndexOutOfBoundsException
		coll.add(2, "kegh");
		System.out.println(coll.get(0));
		System.out.println(coll);

		coll.set(2, "kgh"); // 设置不是添加，是设置
		System.out.println(coll);

		System.out.println(coll.indexOf("kgh"));
		System.out.println(coll.lastIndexOf("kgh"));
	}
}

