package org.wcy.wee.design.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试防止反射和反序列化漏洞
 * @author wcyong
 *
 */
public class Client2 {

	public static void main(String[] args) throws Exception {
		Singleton6 s1 = Singleton6.getInstance();
		Singleton6 s2 = Singleton6.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		
		
		//通过反射的方式直接调用私有构造器
		/*Class<?> clzz = Class.forName("org.wcy.wee.design.singleton.Singleton6");
		
		Constructor<Singleton6> c = (Constructor<Singleton6>) clzz.getDeclaredConstructor(null);
		c.setAccessible(true);
		
		Singleton6 s3 = c.newInstance();
		Singleton6 s4 = c.newInstance();
		
		System.out.println(s3);
		System.out.println(s4);*/
		
		
		//通过反序列化的方式构造多个对象
		FileOutputStream fos = new FileOutputStream("f:/test/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f:/test/a.txt"));
		Singleton6 s5 = (Singleton6) ois.readObject();
		System.out.println(s5);
		
		
	}
}
