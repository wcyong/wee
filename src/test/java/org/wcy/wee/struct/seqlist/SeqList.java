package org.wcy.wee.struct.seqlist;

/**
 * 线性表接口
 * @author wcyong
 *
 */
public interface SeqList<T> {
	
	/**
	 * 插入一个元素（插入链表尾部）
	 * @param element
	 */
	public void insert(T element);
	
	/**
	 * 在指定的位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void insert(int index, T element);
	
	/**
	 * 设置index位置的元素，并返之前的元素
	 * @param index
	 * @param element
	 */
	public void set(int index, T element);
	
	/**
	 * 返回某个位置的元素
	 * @param index
	 * @return
	 */
	public T get(int index);
	
	/**
	 * 删除某个位置的元素，并返回该元素
	 * @param index
	 * @return
	 */
	public T remove(int index);
	
	/**
	 * 清空线性表
	 */
	public void clear();

	/**
	 * 获取长度
	 * @return
	 */
	public int getLength();
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty();
	
}
