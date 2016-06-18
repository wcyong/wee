package org.wcy.wee.dyncompile;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class Demo2 {

	/**
	 * 动态编译
	 * @param args
	 * @throws Exception 
	 */
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
	
		String str = "public class Hello {public static void main(String[] args){System.out.println(\"hello\");} }";
		FileUtils.writeStringToFile(new File("f://test/Hello.java"), str);
		
		JavaCompiler compiler2 = ToolProvider.getSystemJavaCompiler();
		int result2 = compiler2.run(null, null, null, "F:/test/Hello.java");
		System.out.println(result2 == 0 ? "编译成功" : "编译失败");
		
		URL[] urls = new URL[]{new URL("file:/" + "f:/test/")};
		URLClassLoader loader = new URLClassLoader(urls);
		Class c = loader.loadClass("Hello");
		Method m = c.getMethod("main", String[].class);
		m.invoke(null, (Object)new String[]{});
		
	}
	
}
