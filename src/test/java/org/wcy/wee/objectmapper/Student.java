package org.wcy.wee.objectmapper;

import java.util.Date;

public class Student {

	private String name;
	private int age;
	private Date createTime;
	
	public Student() {}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	

	public Student(String name, int age, Date createTime) {
		super();
		this.name = name;
		this.age = age;
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
