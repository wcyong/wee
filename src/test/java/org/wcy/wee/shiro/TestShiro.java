package org.wcy.wee.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class TestShiro {

	@Test
	public void testBase() {
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
		SecurityManager sm = factory.getInstance();
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		
		try {
			UsernamePasswordToken token = new UsernamePasswordToken("wwss", "123");
			subject.login(token);
		} catch(UnknownAccountException e){
			e.printStackTrace();
		}catch(IncorrectCredentialsException e) {
			e.printStackTrace();
		}catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}
}
