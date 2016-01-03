package org.wcy.wee.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.wcy.wee.demo.reflect.Point;

public class PropertyDescriptorTest {

	public static void main(String[] args) throws Exception {
		String propertyName = "x";
		Point p = new Point();
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, p.getClass());
		Method readMethod = pd.getReadMethod();
		//String getMethod = readMethod.getName();
		Object retVal = readMethod.invoke(p);
		System.out.println(retVal);
		
		Method setMethod = pd.getWriteMethod();
		setMethod.invoke(p, 10);
		p.getX();
		
		Object retVal1 = readMethod.invoke(p);
		System.out.println(retVal1);
		
		//==============================================
		BeanInfo beanInfo = Introspector.getBeanInfo(Point.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd2 : propertyDescriptors) {
			System.out.println(pd2.getDisplayName());
			System.out.println(pd2.getReadMethod());
		}
		
	}
}
