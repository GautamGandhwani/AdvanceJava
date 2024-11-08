package co.in.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnection {

	public static void main(String[] args) throws Exception {

		// step 1. Load MySQL Driver (Class loader)
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2. Create Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

		// step 3. Create statement object
		Statement stmt = conn.createStatement();

		// step 4. create query
		ResultSet rs = stmt.executeQuery("select * from employees");

		while (rs.next()) {

			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getString(5));
			System.out.println("\t" + rs.getInt(6));
		}
	}
}