package co.in.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.DnsSrv.SrvRecord;

import co.in.Bean.MarkSheetBean;
import co.in.Model.MarkSheetModel;

@WebServlet("/MarkSheetCtl.do")
public class MarkSheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rollNo = request.getParameter("rollNo");
		System.out.println("RollNo :- " + rollNo);

		MarkSheetBean bean = new MarkSheetBean();
		MarkSheetModel model = new MarkSheetModel();

		if (rollNo != null) {
			try {
				bean = model.findByRollNo(Integer.parseInt(rollNo));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarkSheetView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("Operation = " + op);

		MarkSheetBean bean = new MarkSheetBean();
		MarkSheetModel model = new MarkSheetModel();

		String rollNo = request.getParameter("rollno");
		String name = request.getParameter("name");
		String physics = request.getParameter("physics");
		String chemistry = request.getParameter("chemistry");
		String maths = request.getParameter("maths");

		try {
			bean.setRollNo(Integer.parseInt(rollNo));
			bean.setName(name);
			bean.setPhysics(Integer.parseInt(physics));
			bean.setChemistry(Integer.parseInt(chemistry));
			bean.setMaths(Integer.parseInt(maths));

			if (model.findByRollNo(Integer.parseInt(rollNo)) != null) {
				request.setAttribute("msg", "Roll No Already Exised...");
			} else if (op.equals("save")) {
				model.add(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Add Data Successfully");
			}

			if (op.equals("update")) {

				bean.setId(Integer.parseInt(request.getParameter("id")));
				model.update(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Update Data Successfully");
			}
			RequestDispatcher rd = request.getRequestDispatcher("MarkSheetView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}