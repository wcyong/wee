package org.wcy.wee.dyncompile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class Demo01 {

	/**
	 * 动态编译
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
		String str = "public class Hello {public static void main(String[] args){System.out.println(\"hello\");} }";
		FileUtils.writeStringToFile(new File("f://test/Hello.java"), str);
		
		JavaCompiler compiler2 = ToolProvider.getSystemJavaCompiler();
		int result2 = compiler2.run(null, null, null, "F:/test/Hello.java");
		System.out.println(result2 == 0 ? "编译成功" : "编译失败");
		
		
		Runtime rt = Runtime.getRuntime();
		Process process = rt.exec("java -cp F:/test/ Hello");
		
		InputStream inputStream = process.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = "";
		while((line=reader.readLine()) != null) {
			System.out.println(line);
		}
	}
	
}
