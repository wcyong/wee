package org.wcy.wee.design.composite;

/**
 * 抽象组件
 * @author wcyong
 *
 */
public interface Compoent {

	public void operation();
	
}

//叶子组件
interface Leaf extends Compoent {
	
}

//容器组件
interface Composite extends Compoent {
	public void add(Compoent c);
	public void remove(Compoent c);
	public Compoent getChild(int index);
}
