package club.kegh.ooa.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author By--柯庚宏
 * @user kegh
 * @time 2019年7月1日
 * @QQ 2641195399
 * @注释 List的方法
 */
public class Dm_List {
	public static void main(String[] args) {
		test1();
	}

	/**
	 * list中的常用方法，其中包含collection的方法
	 */
	public static void test1() {
		ArrayList<String> coll = new ArrayList<>();
		coll.add("AA");
		coll.add("BB");
		coll.add("CC");
		coll.add("DD");
		coll.add(2, "kgh"); // 重载add index要小于总长度 否则:java.lang.IndexOutOfBoundsException
		coll.add(2, "kgh");
		System.out.println(coll.get(0));
		System.out.println(coll);
		System.out.println(coll.indexOf("kgh"));
		System.out.println(coll.lastIndexOf("kgh"));
	}

}

/**
 * 
 * @author By--柯庚宏
 * @user kegh
 * @time 2019年7月1日
 * @QQ 2641195399
 * @注释 自定义List,简易版
 * 
 */
class KGHArrayList<E> {
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		KGHArrayList<String> list=new KGHArrayList<String>();
		list.add("AA");
		list.add("BB");
		System.out.println(list.toString());
	}
	
	private Object[] elementData;

	private static final int DEFAULT_CAPACITY = 10;

	private int size;

	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	public KGHArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];// 默认数组长度
	}

	public KGHArrayList(int capacity) {
		elementData = new Object[capacity]; // 带数组长度的构造方法
	}

	// 同源码
	public int size() {
		return size;
	}

	// 同源码
	public boolean isEmpty() {
		return size == 0;
	}

	// 同源码
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	// 同源码
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	// 同源码
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	// 同源码
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			// Make a new array of a's runtime type, but my contents:
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());
		System.arraycopy(elementData, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}

	public boolean add(E e) {
		if(size > elementData.length) {
			int oldCapacity = elementData.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			Object[] newArray=new Object[newCapacity];
			System.arraycopy(elementData, 0, newArray, 0, newArray.length);
		}
        elementData[size++] = e;
        return true;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void clear() {
	        for (int i = 0; i < size; i++)
	            elementData[i] = null;

	        size = 0;
	}

	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		for(Object o:elementData) {
			sb.append(o.toString()).append(",");
		}
		sb.delete(elementData.length-1, elementData.length).append("]");
		return "KGHArrayList []";
	}
	
}
