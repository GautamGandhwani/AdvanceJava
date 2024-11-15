package co.in.JDBC.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserModel {

	public int nextPK() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(Id) from st_user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("Max Id :- " + pk);
		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("co.in.bundle.system");

		Class.forName(rb.getString("driver"));

		Connection c = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));

		PreparedStatement p = c.prepareStatement("insert into st_user values(?,?,?,?,?,?,?)");

		UserBean existBean = new UserBean();

		System.out.println("LoginId " + bean.getLoginId());
		existBean = findByLoginId(bean.getLoginId());

		if (existBean != null) {
			System.out.println("LoginId Already exists.");
		} else {

			p.setInt(1, nextPK());
			p.setString(2, bean.getFirstName());
			p.setString(3, bean.getLastName());
			p.setString(4, bean.getLoginId());
			p.setString(5, bean.getPassWord());
			p.setString(6, bean.getAddress());
			p.setDate(7, new java.sql.Date(bean.getDOB().getTime()));

			int i = p.executeUpdate();

			System.out.println("Data Added Successfully :- " + i);
		}
	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		PreparedStatement p = c.prepareStatement(
				"update st_user set FirstName=?,LastName=?,LoginId=?,PassWord=?,Address=?,DOB=? where Id=?");

		p.setString(1, bean.getFirstName());
		p.setString(2, bean.getLastName());
		p.setString(3, bean.getLoginId());
		p.setString(4, bean.getPassWord());
		p.setString(5, bean.getAddress());
		p.setDate(6, new java.sql.Date(bean.getDOB().getTime()));
		p.setInt(7, bean.getId());

		int i = p.executeUpdate();

		System.out.println("Data Updated Successfully :- " + i);
	}

	public void delete(int Id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		PreparedStatement p = c.prepareStatement("delete from st_user where Id=? ");

		p.setInt(1, Id);

		int i = p.executeUpdate();

		System.out.println("Data Deleted Successfully :- " + i);
	}

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		StringBuilder sql = new StringBuilder("select * from st_user where 1=1");

//		for Search field 
		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "'");
			}

			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "'");
			}
		}

//		for Pagination
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + "," + pageSize);
		}

		PreparedStatement p = c.prepareStatement(sql.toString());

		System.out.println("sql = " + sql.toString());

		ResultSet rs = p.executeQuery();

		UserBean b = null;

		List l = new ArrayList();

		while (rs.next()) {

			b = new UserBean();

			b.setId(rs.getInt(1));
			b.setFirstName(rs.getString(2));
			b.setLastName(rs.getString(3));
			b.setLoginId(rs.getString(4));
			b.setPassWord(rs.getString(5));
			b.setAddress(rs.getString(6));
			b.setDOB(rs.getDate(7));

			l.add(b);
		}
		return l;
	}

	public UserBean authenticate(String LoginId, String PassWord) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement p = c.prepareStatement("select * from st_user where LoginId = ? and PassWord = ?");

		p.setString(1, LoginId);
		p.setString(2, PassWord);

		ResultSet rs = p.executeQuery();

		UserBean b = null;

		while (rs.next()) {

			b = new UserBean();

			b.setId(rs.getInt(1));
			b.setFirstName(rs.getString(2));
			b.setLastName(rs.getString(3));
			b.setLoginId(rs.getString(4));
			b.setPassWord(rs.getString(5));
			b.setAddress(rs.getString(6));
			b.setDOB(rs.getDate(7));
		}
		return b;
	}

	public UserBean findByLoginId(String LoginId) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement p = c.prepareStatement("select * from st_user where LoginId = ?");

		p.setString(1, LoginId);

		ResultSet rs = p.executeQuery();

		UserBean b = null;

		while (rs.next()) {

			b = new UserBean();

			b.setId(rs.getInt(1));
			b.setFirstName(rs.getString(2));
			b.setLastName(rs.getString(3));
			b.setLoginId(rs.getString(4));
			b.setPassWord(rs.getString(5));
			b.setAddress(rs.getString(6));
			b.setDOB(rs.getDate(7));
		}
		return b;
	}
}