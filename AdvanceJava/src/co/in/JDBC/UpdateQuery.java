package co.in.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateQuery {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");
		
		Statement s = c.createStatement();
		
		int i = s.executeUpdate("update employees set Company = 'TCS' Where id = 7");
		
		System.out.println(i);
		
	}
}