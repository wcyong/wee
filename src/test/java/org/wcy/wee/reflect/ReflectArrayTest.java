package org.wcy.wee.reflect;

import java.lang.reflect.Array;

/**
 * 数组反射
 * @author wcyong
 *
 * @date   2015年12月18日
 */
public class ReflectArrayTest {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4};
		printObject(arr);
	}
	
	public static void printObject(Object obj) {
		Class clzz = obj.getClass();
		if(clzz.isArray()) {
			int len = Array.getLength(obj);
			for(int i=0; i<len; i++) {
				System.out.println(Array.get(obj, i));
			}
		}
	}
}
