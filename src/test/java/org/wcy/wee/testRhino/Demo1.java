package org.wcy.wee.testRhino;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 测试脚本引擎
 * @author wcyong
 *
 */
public class Demo1 {

	public static void main(String[] args) throws Exception {
		//获得脚本引擎
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		
		//定义变量,存储到引擎上下文中
		engine.put("msg", "test script engine");
		String str = "var obj = {name:'wwss',age:26};";
		str += "println(obj.name)";
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg= 'test js';");
		System.out.println(engine.get("msg"));
		
		
		//定义函数
		engine.eval("function add(num1, num2){var sum = num1 + num2;return sum}");
		//取得调用接口
		Invocable jsInvocable = (Invocable)engine;
		//执行脚本中定义的方法
		Object rs = jsInvocable.invokeFunction("add", 12, 40);
		System.out.println(rs);
		
		
		String jsStr = "importPackage(java.util); var list = Arrays.asList([\"wwss\",\"Lee\",\"Lon\"])";
		engine.eval(jsStr);
		
		List<String> list = (List<String>) engine.get("list");
		for(String s : list) {
			System.out.println(s);
		}
		
		
		//执行一个js文件
		URL url = Demo1.class.getClassLoader().getResource("org/wcy/wee/testRhino/test.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
	}
	
}
