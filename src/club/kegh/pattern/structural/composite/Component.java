package club.kegh.pattern.structural.composite;

/**
 *	 所有构件
 * @author Administrator
 *
 */
public interface Component {
	void operation();
}


/**
 * 	叶子节点
 */
interface Leaf extends Component{
	@Override
	public void operation();
}

/**
 * 	容器        带天然递归
 */
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChird(int i);
	
	public void operation();
	
	//children  List
	
}
