package co.in.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestUser {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Number :- ");

		int num = sc.nextInt();

		switch (num) {
		case 1:
			adduser();
			break;

		case 2:
			updateuser();
			break;

		case 3:
			deleteuser();
			break;

		case 4:
			surchuser();
			break;

		default:
			System.out.println("\n"+"not found");
			break;
		}
	}

	private static void adduser() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		Statement s = c.createStatement();

		int i = s.executeUpdate(
				"insert into st_user value(1,'Gaurav','Varma','gaurav@gmail.com','pass123','Indore','2003-03-02')");

		System.out.println("\n"+"Data Added Successfully :- " + i);

	}

	private static void updateuser() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		Statement s = c.createStatement();

		int i = s.executeUpdate("update st_user set DOB = '1994-12-29',Address = 'Chittodagarh' where Id = 1");

		System.out.println("\n"+"Data Updated Successfully :- " + i);

	}

	private static void deleteuser() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		Statement s = c.createStatement();

		int i = s.executeUpdate("delete from st_user where Id = 1");

		System.out.println("\n"+"Data Deleted Successfully :- " + i);

	}

	private static void surchuser() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		Statement s = c.createStatement();

		ResultSet rs = s.executeQuery("select * from st_user");

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t " + rs.getString(2));
			System.out.print("\t " + rs.getString(3));
			System.out.print("\t " + rs.getString(4));
			System.out.print("\t " + rs.getString(5));
			System.out.print("\t " + rs.getString(6));
			System.out.println("\t " + rs.getDate(7));

		}

	}

}
