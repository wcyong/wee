package org.wcy.wee.design.singleton;

/**
 * 枚举方式实现(没有延时加载)
 * @author wcyong
 *
 */
public enum Singleton5 {

	//这个枚举元素，本身就是单例对象
	INSTANCE;
	
	//添加自己需要的操作
	public void singletonOperation() {
		
	}
	
}
