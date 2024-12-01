package co.in.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.in.Bean.CollegeBean;
import co.in.Util.JDBCDataSource;

public class CollegeModel {

	public int nextPk() throws Exception {
		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_college");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

			System.out.println("max id =" + pk);
		}
		return pk + 1;
	}

	public void add(CollegeBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_college values(?,?,?,?,?,?)");

		pstmt.setInt(1, nextPk());
		pstmt.setString(2 , bean.getName());
		pstmt.setString(3, bean.getAddress());
		pstmt.setString(4, bean.getState());
		pstmt.setString(5, bean.getCity());
		pstmt.setString(6, bean.getPhoneno());

		int i = pstmt.executeUpdate();
		System.out.println("Data Added Successfully = " + i);
	}

	public void update(CollegeBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn
				.prepareStatement("update st_college set name=?,address=?,state=?,city=?,phoneno=? where id=?");

		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getAddress());
		pstmt.setString(3, bean.getState());
		pstmt.setString(4, bean.getCity());
		pstmt.setString(5, bean.getPhoneno());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data Updated Successfully = +i");
	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_college where id=?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Data Deleted Successfully = " + i);
	}

	public List search(CollegeBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_college");

		ResultSet rs = pstmt.executeQuery();

		bean = null;
		
		List list = new ArrayList();
		
		while (rs.next()) {
			bean =new CollegeBean();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setAddress(rs.getString(3));
			bean.setState(rs.getString(4));
			bean.setCity(rs.getString(5));
			bean.setPhoneno(rs.getString(6));
			
			list.add(bean);
		}
		return list;
	}
	
	public CollegeBean findById() {
		
	}
}
