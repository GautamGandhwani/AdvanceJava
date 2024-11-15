package co.in.JDBC.PreparedStatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
//	    testAthenticate();
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

		UserModel m = new UserModel();

		UserBean b = new UserBean();

		b.setFirstName("Arin");
		b.setLastName("Tomar");
		b.setLoginId("arin12@gmail.com");
		b.setPassWord("pass123");
		b.setAddress("Indore");
		b.setDOB(s.parse("2004-07-24"));

		m.add(b);
	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD");

		UserModel m = new UserModel();

		UserBean b = new UserBean();

		b.setFirstName("Sumit");
		b.setLastName("Prajapat");
		b.setLoginId("sumit@gmail.com");
		b.setPassWord("pass123");
		b.setAddress("indore");
		b.setDOB(s.parse("2005-08-21"));
		b.setId(3);

		m.update(b);

	}

	private static void testDelete() throws Exception {

		UserModel m = new UserModel();

		m.delete(3);
	}

	private static void testSearch() throws Exception {

		UserModel m = new UserModel();
		
		UserBean bean = new UserBean();
		
	//	bean.setFirstName("Mohit");
//		bean.setLastName("Varma");
			
		List l = m.search(bean,1,3);

		Iterator it = l.iterator();
		
		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassWord());
			System.out.print("\t" + bean.getAddress());
			System.out.println("\t" + bean.getDOB());
		}
	}
	private static void testAthenticate() throws Exception {
		
		UserModel m = new UserModel();
		
		UserBean b = m.authenticate("gaurav@gmail.com", "pass123");
		
		if (b != null) {
			
			System.out.println(b.getFirstName());
			System.out.println(b.getLastName());
			
		} else {
			System.out.println("User Not Found");
		}
	}
}
