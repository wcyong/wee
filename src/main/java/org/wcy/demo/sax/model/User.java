package org.wcy.demo.sax.model;

/**
 * xml节点对象
 * @author wcyong
 *
 * date    2015年7月23日
 */
public class User {

	private Long id;
	private String name;
	private Long age;
	private String hobby;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
