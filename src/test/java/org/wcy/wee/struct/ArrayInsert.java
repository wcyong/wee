package org.wcy.wee.struct;
/**
 * 在线性表的第i-1个数据元素和第i个数据元素之间插入一个新的数据元素，使线性表的长度增加一个元素的空间
 * 		必须从第i个元素到第array.length-1个元素向后平移，空出一个存储单元后，插入该元素
 * 		对数据元素进行平等向后移动时，遵循存储单元存储的后入为主的原则，否则将造成数据丢失
 * @author wcyong
 *
 */
public class ArrayInsert {

	public static void main(String[] args) {
		int[] narray = {1,3,5,7,9};
		//例如在2个位置插入8
		int i = 2;
		
		for(int k = narray.length-1; k>i; k--) {
			narray[k+1] = narray[k];
			narray[i] = 8;
		}
		System.out.println(narray.toString());
		
		System.out.println(narray.length);
	}
}
