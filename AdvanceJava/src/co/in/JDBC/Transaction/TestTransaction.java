package co.in.JDBC.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
//			Step 1
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into st_user values(5,'Aman','Sharma','aman@gmail.com','pass123','Bhopal','2004-04-21')");

			i = stmt.executeUpdate("insert into st_user values(5,'Aman','Sharma','aman@gmail.com','pass123','Bhopal','2004-04-21')");

			i = stmt.executeUpdate("insert into st_user values(5,'Aman','Sharma','aman@gmail.com','pass123','Bhopal','2004-04-21')");

			i = stmt.executeUpdate("insert into st_user values(5,'Aman','Sharma','aman@gmail.com','pass123','Bhopal','2004-04-21')");

//			Step 2
//			conn.commit();
			
		} catch (Exception e) {
			
//			Step 3	
//			conn.rollback();
			
			System.out.println(e.getMessage());
		}

	}
}
