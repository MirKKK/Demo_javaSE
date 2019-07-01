package club.kegh.ooa.collection.mycollection;

import java.util.Arrays;


/**
 * 
 * @author	By--柯庚宏
 * @user	Administrator
 * @time	2019年7月1日
 * @QQ		2641195399
 * @注释		
 * 			 自定义List,简易版
 */
public class KGHArrayList<E> {
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		KGHArrayList<String> list = new KGHArrayList<String>();
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
		if (capacity < 0) {
			throw new RuntimeException("容器的容量不能为负数");
		} else if (capacity == 0) {
			elementData = new Object[DEFAULT_CAPACITY];
		} else {
			elementData = new Object[capacity];
		}
	}

	/**
	 * 同源码
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 同源码
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 同源码
	 * @return
	 */
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * 同源码
	 * @return
	 */
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

	/**
	 * 同源码
	 * @return
	 */
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	/**
	 * 同源码
	 * @return
	 */
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
		// 什么时候扩容？？
		if (size > elementData.length) {
			int oldCapacity = elementData.length;
			int newCapacity = oldCapacity + (oldCapacity >> 1);
			Object[] newArray = new Object[newCapacity];
			System.arraycopy(elementData, 0, newArray, 0, newArray.length);
		}
		elementData[size++] = e;
		return true;
	}

	public E get(int index) {
		checkRange(index);
		return (E) elementData[index];
	}

	public void set(E element, int index) {
		checkRange(index);
		elementData[index] = element;
	}

	public void checkRange(int index) {
		// 索引合法判断 [0,size) 10 0-9
		if (index < 0 || index > size - 1) {
			// 不合法
			throw new RuntimeException("索引不合法:" + index);
		}
	}

	public boolean remove(Object e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(get(i))) { // 容器中所有的比较操作，都是用的equals而不是==
				// 将该元素从此处移除
				remove(i);
			}
		}
		return true;
	}

	
	public void remove(int index) {
		// a,b,c,d,e,f,g,h
		// a,b,c,e,f,g,h,h
		int numMoved = elementData.length - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--size] = null;
	}

	public void clear() {
		for (int i = 0; i < size; i++)
			elementData[i] = null;
		size = 0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<size;i++){
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']'); 
		return sb.toString();
	}
}

