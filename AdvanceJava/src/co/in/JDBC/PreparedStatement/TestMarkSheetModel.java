package co.in.JDBC.PreparedStatement;

import java.util.Iterator;
import java.util.List;

public class TestMarkSheetModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
//		testMeritList();
	}

	private static void testAdd() throws Exception {

		MarkSheetModel model = new MarkSheetModel();

		MarkSheetBean bean = new MarkSheetBean();
		
		bean.setRollNo(1012);
		bean.setName("Raj");
		bean.setPhysics(55);
		bean.setChemistry(69);
		bean.setMaths(56);

		model.add(bean);
	}

	private static void testUpdate() throws Exception {

		MarkSheetModel model = new MarkSheetModel();

		MarkSheetBean bean = new MarkSheetBean();

		bean.setRollNo(1012);
		bean.setName("Ajay");
		bean.setPhysics(56);
		bean.setChemistry(48);
		bean.setMaths(84);
		bean.setId(12);

		model.update(bean);
	}

	private static void testDelete() throws Exception {

		MarkSheetModel model = new MarkSheetModel();

		model.delete(12);
	}

	private static void testSearch() throws Exception {
		
		MarkSheetModel model = new MarkSheetModel();
		
		MarkSheetBean bean = new MarkSheetBean();
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			bean = (MarkSheetBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getRoll_no());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		}
	}

//	private static void testMeritList() throws Exception {
//		
//		MarkSheetModel model = new MarkSheetModel();
//		
//		MarkSheetBean bean = new MarkSheetBean();
//		
//		List list = model.search(bean);
//		
//		Iterator it = list.iterator();
//		
//		while (it.hasNext()) {
//			
//			bean = (MarkSheetBean) it.next();
//			
//			System.out.print(bean.getId());
//			System.out.print("\t"+bean.getRoll_no());
//			System.out.print("\t"+bean.getName());
//			System.out.print("\t"+bean.getPhysics());
//			System.out.print("\t"+bean.getChemistry());
//			System.out.println("\t"+bean.getMaths());
//		}	
//	}
}