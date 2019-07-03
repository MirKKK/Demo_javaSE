package club.kegh.regular;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author	By--柯庚宏
 * @user	kegh
 * @time	2019年7月3日
 * @QQ		2641195399
 * @注释
 * 			正则在java中的应用
 */
public class Dm_Regex2 {
	
	public static void main(String[] args) {
		String regex="\\w+"; //java中单个\要变成双\\
		Pattern p=Pattern.compile(regex);
		
		System.out.println("---------matches整个字符是否匹配---------");
		//matches匹配整个字符序列
		Matcher m=p.matcher("i love u");
		boolean b = m.matches();
		System.out.println(b);//是否匹配
		
		m=p.matcher("asdfasdfasd");
		b = m.matches();
		System.out.println(b);
		
		
		System.out.println("---------find是否有符合---------");
		//find匹配其中是否符合  只想第一个,再次调用指针下一个
		m=p.matcher("aaaaa&&bbbbb&&aabbcc");
		b = m.find();//aaaaa
		System.out.println(b);
		b = m.find();//bbbbb
		System.out.println(b);
		b = m.find();//aabbcc
		System.out.println(b);
		b = m.find();//找不到了
		System.out.println(b);
		
		
		System.out.println("---------group查看符合的字符---------");
		m=p.matcher("aaaaa&&bbbbb&&aabbcc");
//		System.out.println(m.find());
//		System.out.println(m.group());//返回字符串
		while(m.find()) {
			System.out.println(m.group());//返回字符串
			System.out.println(m.group(0));//返回字符串
		}
		
		
		System.out.println("---------()对分组的处理group(n)---------");
		regex="([a-z]+)([0-9]+)"; 
		p=Pattern.compile(regex);
		m=p.matcher("aaa11&&bbb22&&aabbcc333");
		while(m.find()) {
			System.out.println(m.group(1));//返回分组1
			System.out.println(m.group(2));//返回分组2
		}
		
		
		System.out.println("---------替换---------");
		regex="[0-9]+&&|[0-9]+"; 
		p=Pattern.compile(regex);
		m=p.matcher("aaa11&&bbb22&&aabbcc333");
		String replaceAll = m.replaceAll("##");
		System.out.println(replaceAll);
		
		
		System.out.println("---------分割---------");
		String str="aa1314bbb520ccc";
		String[] split = str.split("\\d+");
		System.out.println(Arrays.toString(split));
	}
	
}
