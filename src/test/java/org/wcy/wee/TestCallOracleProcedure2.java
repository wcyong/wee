package org.wcy.wee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import oracle.jdbc.OracleTypes;

/**
 * java调用Oracle存储过程
 * @author wcyong
 *
 */
public class TestCallOracleProcedure2 {
	
	/**
	 * 调用无返回值的存储过程
	 */
	@Test
	public void testCallOraclPro1() {
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "wcy675600920");
			//3.创建CallableStatement
			CallableStatement cs = connection.prepareCall("{call wwss_pro9(?,?,?)}");
			//4.给？赋值
			cs.setInt(1, 2);
			cs.setString(2, "java程序设计");
			cs.setString(3, "人民出版社");
			//5.执行
			cs.execute();
			//6.关闭
			cs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 调用有输入和输出的存储过程
	 */
	@Test
	public void testCallOraclPro2() {
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "wcy675600920");
			//3.创建CallableStatement
			CallableStatement cs = connection.prepareCall("{call wwss_pro10(?,?)}");
			//4.给第一个？赋值
			cs.setInt(1, 7369);
			//给第二个?赋值
			cs.registerOutParameter(2, OracleTypes.VARCHAR);
			
			//5.执行
			cs.execute();
			
			//取出返回值,要注意?顺序
			String name = cs.getString(2);//返回值是第二个？
			System.out.println(name);
			
			
			//6.关闭
			cs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 调用有输入和多个返回值的存储过程
	 */
	@Test
	public void testCallOraclPro3() {
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "wcy675600920");
			//3.创建CallableStatement
			CallableStatement cs = connection.prepareCall("{call wwss_pro11(?,?,?,?)}");
			//4.给第一个？赋值
			cs.setInt(1, 7369);
			//给第二个?赋值
			cs.registerOutParameter(2, OracleTypes.VARCHAR);
			cs.registerOutParameter(3, OracleTypes.FLOAT);
			cs.registerOutParameter(4, OracleTypes.VARCHAR);
			
			//5.执行
			cs.execute();
			
			//取出返回值,要注意?顺序
			String name = cs.getString(2);//返回值是第二个？
			System.out.println(name);
			float sal = cs.getFloat(3);
			System.out.println(sal);
			String job = cs.getString(4);
			System.out.println(job);
			
			//6.关闭
			cs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回列表
	 */
	@Test
	public void testCallOraclPro4() {
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "wcy675600920");
			//3.创建CallableStatement
			CallableStatement cs = connection.prepareCall("{call wwss_pro12(?,?)}");
			
			//4.给第一个？赋值
			cs.setInt(1, 20);
			//给第二个?赋值
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			
			//5.执行
			cs.execute();
			
			//取出返回值,要注意?顺序
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()) {
				System.out.println(rs.getInt(1) +","+rs.getString(2));
			}
			
			//6.关闭
			cs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 调用分页存储过程
	 */
	@Test
	public void testCallOraclPro5() {
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "wcy675600920");
			//3.创建CallableStatement
			CallableStatement cs = connection.prepareCall("{call fenye(?,?,?,?,?,?)}");
			
			//4.给第一个？赋值
			cs.setString(1, "emp");
			cs.setInt(2, 5);
			cs.setInt(3, 4);
			cs.registerOutParameter(4, OracleTypes.INTEGER);
			cs.registerOutParameter(5, OracleTypes.INTEGER);
			cs.registerOutParameter(6, OracleTypes.CURSOR);
			
			//5.执行
			cs.execute();
			
			//取出返回值,要注意?顺序
			int totalCount = cs.getInt(4);
			int totalPage = cs.getInt(5);
			System.out.println("总记录数：" + totalCount);
			System.out.println("总页数：" + totalPage);
			ResultSet rs = (ResultSet) cs.getObject(6);
			System.out.println("数据：");
			while(rs.next()) {
				System.out.println(rs.getInt(1) +","+rs.getString(2)+","+rs.getString("job"));
			}
			
			//6.关闭
			cs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
