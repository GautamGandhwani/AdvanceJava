package co.in.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.in.Bean.StudentBean;
import co.in.Model.StudentModel;

@WebServlet("/StudentCtl.do")
public class StudentCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("Id = " + id);

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		if (id != null) {
			try {
				bean = model.findById(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String op = request.getParameter("operation");
		System.out.println("Operation = " + op);

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String collageName = request.getParameter("collageName");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String dob = request.getParameter("dob");

		try {
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setCollageName(collageName);
			bean.setEmail(email);
			bean.setMobileNo(mobileNo);
			bean.setDob(sdf.parse(dob));

			if (model.findByEmail(email) != null) {
				request.setAttribute("msg", "Email Already Exist...");
			} else if (op.equals("save")) {

				model.add(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Data Add Successfully");
			}

			if (op.equals("update")) {

				bean.setId(Integer.parseInt(request.getParameter("id")));
				model.update(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Data Update Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.forward(request, response);
	}
}