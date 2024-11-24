package co.in.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.in.Bean.MarkSheetBean;
import co.in.Util.JDBCDataSource;

public class MarkSheetModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("Max Id = " + pk);
		}
		return pk + 1;
	}

	public void add(MarkSheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?)");

		MarkSheetBean existBean = new MarkSheetBean();

		System.out.println("Roll Number :- " + bean.getRollNo());
		existBean = findByRollNo(bean.getRollNo());

		if (existBean != null) {

			System.out.println("Roll Number Already Exist.");

		} else {

			pstmt.setInt(1, nextPk());
			pstmt.setInt(2, bean.getRollNo());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhysics());
			pstmt.setInt(5, bean.getChemistry());
			pstmt.setInt(6, bean.getMaths());

			int i = pstmt.executeUpdate();

			System.out.println("Data Added Successfully :- " + i);
		}
	}

	public void update(MarkSheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_marksheet set rollno = ?, name = ?,physics = ?,chemistry = ?,maths = ? where Id = ?");

		pstmt.setInt(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data Updated Successfully :-" + i);
	}

	public void delete(int Id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where Id = ?");

		pstmt.setInt(1, Id);

		int i = pstmt.executeUpdate();

		System.out.println("Data Deleted Successfully :- " + i);
	}

	public List search(MarkSheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(bean.getName().length());
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

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

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where rollno =?");

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

}