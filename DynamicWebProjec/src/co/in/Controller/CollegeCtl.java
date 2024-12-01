package co.in.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.in.Bean.CollegeBean;
import co.in.Model.CollegeModel;

@WebServlet("/CollegeCtl.do")
public class CollegeCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("CollegeView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String phoneno = request.getParameter("phoneno");

		try {

			bean.setName(name);
			bean.setAddress(address);
			bean.setState(state);
			bean.setCity(city);
			bean.setPhoneno(phoneno);

			model.add(bean);
			request.setAttribute("bean", bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("CollegeView.jsp");
		rd.forward(request, response);
	}
}
