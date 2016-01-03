package org.wcy.wee.reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GenricTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Integer> list = new ArrayList<Integer>();
		list.getClass().getMethod("add", Object.class).invoke(list, "abc");
		System.out.println(list.size());
		System.out.println(list.get(0));
	}
}
