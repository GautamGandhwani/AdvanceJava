package co.in.JDBC.PreparedStatement.Student;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

		testAdd();
//		testUpdate();
//		testDelete();
//		testsearch();
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

		StudentModel model = new StudentModel();

		StudentBean bean = new StudentBean();

		
		bean.setFirstName("Mohit");
		bean.setLastName("Prajapat");
		bean.setCollageName("VIIT");
		bean.setEmail("mohit@gmail.com");
		bean.setMobileNo("9009216591");
		bean.setDob(sdf.parse("2003-05-26"));

		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

		StudentModel model = new StudentModel();

		StudentBean bean = new StudentBean();

		bean.setId(2);
		bean.setFirstName("Sumit");
		bean.setLastName("Prajapat");
		bean.setCollageName("VIIT");
		bean.setEmail("sumit@gmail.com");
		bean.setMobileNo("9009216491");
		bean.setDob(sdf.parse("2005-05-29"));

		model.update(bean);
	}

	private static void testDelete() throws Exception {

		StudentModel model = new StudentModel();

		model.delete(3);

	}

	private static void testsearch() throws Exception {

		StudentModel model = new StudentModel();

		StudentBean bean = new StudentBean();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getCollageName());
			System.out.print("\t" + bean.getEmail());
			System.out.print("\t" + bean.getMobileNo());
			System.out.println("\t" + bean.getDob());
		}
	}
}
