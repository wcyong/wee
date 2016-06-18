package org.wcy.wee.testjavassist;

import javassist.ClassPool;
import javassist.CtClass;

public class Demo01 {

	public static void main(String[] args) {
		ClassPool pool = ClassPool.getDefault();
		
		CtClass ct = pool.makeClass("");
		
	}
}
