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

		SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD");

		UserModel m = new UserModel();

		UserBean b = new UserBean();

		b.setId(5);
		b.setFirstName("Mohit");
		b.setLastName("Prajapat");
		b.setLoginId("mohit@gmail.com");
		b.setPassWord("pass123");
		b.setAddress("indore");
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
		bean.setLastName("Varma");
			
		List l = m.search(bean);

		Iterator it = l.iterator();

		UserBean b = new UserBean();

		while (it.hasNext()) {
			b = (UserBean) it.next();

			System.out.print(b.getId());
			System.out.print("\t" + b.getFirstName());
			System.out.print("\t" + b.getLastName());
			System.out.print("\t" + b.getLoginId());
			System.out.print("\t" + b.getPassWord());
			System.out.print("\t" + b.getAddress());
			System.out.println("\t" + b.getDOB());
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
