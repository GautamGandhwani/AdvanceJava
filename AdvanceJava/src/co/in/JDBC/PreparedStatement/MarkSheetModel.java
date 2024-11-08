package co.in.JDBC.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarkSheetModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("Max Id = " + pk);
		}
		return pk + 1;
	}

	public void add(MarkSheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

		MarkSheetBean existBean = new MarkSheetBean();

		System.out.println("Roll Number :- " + bean.getRoll_no());
		existBean = findByRollNo(bean.getRoll_no());

		if (existBean != null) {

			System.out.println("Roll Number Already Exist.");

		} else {

			pstmt.setInt(1, nextPk());
			pstmt.setInt(2, bean.getRoll_no());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhysics());
			pstmt.setInt(5, bean.getChemistry());
			pstmt.setInt(6, bean.getMaths());

			int i = pstmt.executeUpdate();

			System.out.println("Data Added Successfully :- " + i);
		}
	}

	public void update(MarkSheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update marksheet set Roll_no = ?, Name = ?,Physics = ?,Chemistry = ?,Maths = ? where Id = ?");

		pstmt.setInt(1, bean.getRoll_no());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data Updated Successfully :-" + i);
	}

	public void delete(int Id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where Id = ?");

		pstmt.setInt(1, Id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted Successfully :- " + i);
	}

	public List search(MarkSheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarkSheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);
		}
		return list;
	}

	public MarkSheetBean findByRollNo(int rollNo) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where Roll_no =?");

		pstmt.setInt(1, rollNo);

		ResultSet rs = pstmt.executeQuery();

		MarkSheetBean bean = null;

		while (rs.next()) {

			bean = new MarkSheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;
	}

	public List meritList(MarkSheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"select *, (physics+chemistry+maths) as total, ((physics+chemistry+maths)/3) as percentage from marksheet where physics >= 60 and chemistry >= 60 and maths >= 60 order by total desc limit 0,3");

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new MarkSheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);
		}
		return list;
	}
}