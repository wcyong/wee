package org.wcy.wee.common.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author wcyong
 *
 * @date   2015年12月11日
 */
public class ClassUtils {

	/**
	 * 给一个接口，返回这个接口的所有实现类
	 * @param c
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Class> getAllClassByInterface(Class c) {
		//返回结果
		List<Class> returnClassList = new ArrayList<Class>();
		//如果是接口
		if(c.isInterface()) {
			//获得当前的包名
			String packageName = c.getPackage().getName();
			try {
				//获得当前包下以及子包下的所有类
				List<Class> allClass = getClass(packageName);
				//判断是否是同一接口
				for(int i=0; i<allClass.size(); i++) {
					//判断是不是一个接口
					if(c.isAssignableFrom(allClass.get(i))) {
						//本身不加进去
						if(!c.equals(allClass.get(i))) {
							returnClassList.add(allClass.get(i));
						}
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return returnClassList;
	}

	/**
	 * 从一个包中查找出所有的类，在jar包中不能查找
	 * @param packageName
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("rawtypes")
	private static List<Class> getClass(String packageName) throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace(".", "/");
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while(resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		List<Class> classes = new ArrayList<Class>();
		for(File dir : dirs) {
			classes.addAll(findClasses(dir, packageName));
		}
		return classes;
	}

	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File dir, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if(!dir.exists()) {
			return classes;
		}
		File[] files = dir.listFiles();
		for(File file : files) {
			if(file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if(file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}
}
