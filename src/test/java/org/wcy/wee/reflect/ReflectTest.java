package org.wcy.wee.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class ReflectTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IOException {
		/*Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
		System.out.println(constructor.getName());*/
		//InputStream is = ReflectTest.class.getClassLoader().getResourceAsStream("db.properties");
		InputStream is = ReflectTest.class.getResourceAsStream("/db.properties");
		Properties prop = new Properties();
		prop.load(is);
		Object object = prop.get("jdbc.driver");
		System.out.println(object);
	}
}
