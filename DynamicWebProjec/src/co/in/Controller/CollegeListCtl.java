package co.in.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.in.Bean.CollegeBean;
import co.in.Model.CollegeModel;

@WebServlet("/CollegeListCtl.do")
public class CollegeListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		try {
			List list = model.search(bean);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("CollegeListView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("Operation = "+op);

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {
			for (String id : ids) {
				try {
					model.delete(Integer.parseInt(id));
					List list = model.search(bean);
					request.setAttribute("list", list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher("CollegeListView.jsp");
		rd.forward(request, response);
	}

}
