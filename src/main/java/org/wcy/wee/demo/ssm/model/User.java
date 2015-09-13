package org.wcy.wee.demo.ssm.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.wcy.wee.demo.ssm.validation.ValidGroup1;
import org.wcy.wee.demo.ssm.validation.ValidGroup2;

public class User {
    private Integer id;

    /**
     * 校验username在1至5个字符之间
     * message是提示校验出错显示的信息
     * groups:些校验是属于哪个分组，group可以定义多个分组
     */
    @Size(min=1,max=5,message="{user.username.length.error}",groups={ValidGroup1.class})
    private String username;

    @NotNull(message="{user.birthday.isNUll}",groups={ValidGroup2.class})
    private Date birthday;

    //增加了分组校验后，未分组的校验方法不起作用
    @NotNull(message="{user.sex.error}")
    private String sex;

    private String address;
    
    private String pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
    
}