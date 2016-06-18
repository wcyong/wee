package org.wcy.wee.design.prototype;

import java.util.Date;

import oracle.net.aso.s;

public class Sheep implements Cloneable{

	private String sname;
	private Date birthday;
	
	
	public Sheep(String sname, Date birthday) {
		super();
		this.sname = sname;
		this.birthday = birthday;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		//直接调用Object的clone方法
		Object obj = super.clone();
		
		//把属性也进行克隆
		Sheep s = (Sheep)obj;
		s.birthday = (Date)this.birthday.clone();
		
		return obj;
	}
	
}
