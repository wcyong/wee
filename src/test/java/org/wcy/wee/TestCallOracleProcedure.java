package org.wcy.wee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * java调用Oracle存储过程
 * @author wcyong
 *
 */
public class TestCallOracleProcedure {

	public static void main(String[] args) {
		
		try {
			//1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.获取连接
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "SCOTT", "wcy675600920");
			//3.创建CallableStatement
			CallableStatement cs = connection.prepareCall("{call wwss_pro3(?,?)}");
			//4.给？赋值
			cs.setString(1, "9527");
			cs.setInt(2, 3000);
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
}
