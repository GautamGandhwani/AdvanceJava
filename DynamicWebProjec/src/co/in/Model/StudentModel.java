package co.in.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.in.Bean.StudentBean;
import co.in.Util.JDBCDataSource;

public class StudentModel {

	public int nextPK() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_student");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("Max Id :- " + pk);
		}
		return pk + 1;

	}

	public void add(StudentBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_student values(?,?,?,?,?,?,?)");



//		only for find by email

		StudentBean existBean = new StudentBean();

		System.out.println("Email :- " + bean.getEmail());
		existBean = findByEmail(bean.getEmail());

		if (existBean != null) {
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

		Connection conn = JDBCDataSource.getConnection();

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

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_student where id = ?");

		pstmt.setInt(1, Id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted Successfully :- " + i);
	}

	public List search(StudentBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("Select * from st_student where 1=1");

		if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
			sql.append(" and firstName like '" + bean.getFirstName() + "'");
		}

		if (bean.getLastName() != null && bean.getLastName().length() > 0) {
			sql.append(" and lastName like '" + bean.getLastName() + "'");
		}

		if (bean.getCollageName() != null && bean.getCollageName().length() > 0) {
			sql.append(" and collageName like '" + bean.getCollageName() + "'");
		}

		if (bean.getEmail() != null && bean.getEmail().length() > 0) {
			sql.append(" and email like '" + bean.getEmail() + "'");
		}

		if (bean.getMobileNo() != null && bean.getMobileNo().length() > 0) {
			sql.append(" and mobileNo like '" + bean.getMobileNo() + "'");
		}

		if (bean.getDob() != null && bean.getDob().getTime() > 0) {
			Date d = new Date(bean.getDob().getTime());
			sql.append(" and dob like '" + d + "'");

		}

//		For Pagination
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		System.out.println("SQL = " + sql.toString());

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

		Connection conn = JDBCDataSource.getConnection();

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

		Connection conn = JDBCDataSource.getConnection();

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