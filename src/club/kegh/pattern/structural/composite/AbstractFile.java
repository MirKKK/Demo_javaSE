package club.kegh.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

//抽象构建
public interface AbstractFile {
	public void killVirus();//杀毒方法
}

class ImageFile implements AbstractFile{
	private String  name ;
	public ImageFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
		System.out.println("leaf:查杀"+name+"图片.........");
	}
}


class TextFile implements AbstractFile{
	private String  name ;
	public TextFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
		System.out.println("leaf:查杀"+name+"文本.........");

	}
}


class VedioFile implements AbstractFile{
	private String  name ;
	public VedioFile(String name) {
		super();
		this.name = name;
	}
	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
		System.out.println("leaf:查杀"+name+"视频.........");
	}
}

class Folder implements AbstractFile{
	private String  name ;
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	//定义容器
	private List<AbstractFile> array=new ArrayList<AbstractFile>(); 
	
	public Folder add(AbstractFile file) {
		array.add(file);
		return this;
	}
	
	
	public Folder remove(AbstractFile file) {
		array.remove(array.indexOf(file));
		return this;
	}
	
	public AbstractFile getChird(int i) {
		return array.get(i);
	}
	
	@Override
	public void killVirus() {
		// TODO Auto-generated method stub
		System.out.println("-----composite：检索"+name+"文件夹.......");
		for(AbstractFile file:array) {
			/**
			 * 如果调用容器节点则 会产生递归
			 */
			file.killVirus();
		}
	}
}