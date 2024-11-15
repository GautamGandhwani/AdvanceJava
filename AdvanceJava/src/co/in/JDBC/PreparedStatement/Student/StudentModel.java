package co.in.JDBC.PreparedStatement.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {

	public int nextPK() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_student");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("Max Id :- " + pk);
		}
		return pk + 1;

	}

	public void add(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_student values(?,?,?,?,?,?,?)");

//		only for add
		
//		pstmt.setInt(1, nextPK());
//		pstmt.setString(2, bean.getFirstName());
//		pstmt.setString(3, bean.getLastName());
//		pstmt.setString(4, bean.getCollageName());
//		pstmt.setString(5, bean.getEmail());
//		pstmt.setString(6, bean.getMobileNo());
//		pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));
//
//		int i = pstmt.executeUpdate();
//		System.out.println("Data added successfully :- " + i);

//		only for find by id
		
		StudentBean existBean1 = new StudentBean();

		System.out.println("Id :- " + bean.getId());
		existBean1 = findById(bean.getId());

		if (existBean1 != null) {
			System.out.println("Id Already exists.");
		} else {

			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getCollageName());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();
			System.out.println("Data added successfully :- " + i);
		}

//		only for find by email
		
		StudentBean existBean2 = new StudentBean();

		System.out.println("Email :- " + bean.getEmail());
		existBean2 = findByEmail(bean.getEmail());

		if (existBean2 != null) {
			System.out.println("Email Already exists.");
		} else {

			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getCollageName());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();
			System.out.println("Data added successfully :- " + i);
		}
	}

	public void update(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_student set firstname=?,lastname=?,collagename=?,email=?,mobileno=?,dob=? where id=?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getCollageName());
		pstmt.setString(4, bean.getEmail());
		pstmt.setString(5, bean.getMobileNo());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(7, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data Updated Successfully :- " + i);

	}

	public void delete(int Id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_student where id = ?");

		pstmt.setInt(1, Id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted Successfully :- " + i);
	}

	public List search(StudentBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Select * from st_student");

		ResultSet rs = pstmt.executeQuery();

		bean = null;

		List list = new ArrayList();

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setCollageName(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setDob(rs.getDate(7));

			list.add(bean);
		}
		return list;
	}

	public StudentBean findById(int Id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Select * from st_student where id =?");

		pstmt.setInt(1, Id);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setCollageName(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setDob(rs.getDate(7));
		}
		return bean;
	}

	public StudentBean findByEmail(String Email) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("Select * from st_student where email =?");

		pstmt.setString(1, Email);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setCollageName(rs.getString(4));
			bean.setEmail(rs.getString(5));
			bean.setMobileNo(rs.getString(6));
			bean.setDob(rs.getDate(7));
		}
		return bean;
	}
}
