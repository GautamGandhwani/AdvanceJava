package co.in.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.in.Bean.MarkSheetBean;
import co.in.Model.MarkSheetModel;

@WebServlet("/MarkSheetListCtl.do")
public class MarkSheetListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MarkSheetModel model = new MarkSheetModel();
		MarkSheetBean bean = new MarkSheetBean();

		try {
			List list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarkSheetListView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		int pageNo = 1;
		int pageSize = 5;

		System.out.println("Operatin = " + op);

		MarkSheetModel model = new MarkSheetModel();
		MarkSheetBean bean = new MarkSheetBean();

		String[] ids = request.getParameterValues("ids");

		try {
			if (op.equals("delete")) {

				for (String id : ids) {
					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			if (op.equals("search")) {
				if (request.getParameter("rollNo") != "") {
					bean.setRollNo(Integer.parseInt(request.getParameter("rollNo")));
				}

				if (request.getParameter("name") != "") {
					bean.setName(request.getParameter("name"));
				}
				if (request.getParameter("physics") != "") {
					bean.setPhysics(Integer.parseInt(request.getParameter("physics")));
				}

				if (request.getParameter("chemistry") != "") {
					bean.setChemistry(Integer.parseInt(request.getParameter("chemistry")));
				}

				if (request.getParameter("maths") != "") {
					bean.setMaths(Integer.parseInt(request.getParameter("maths")));
				}
			}

			if (op.equals("next")) {

				pageNo = Integer.parseInt(request.getParameter("pageNo"));

				pageNo++;
			}

			if (op.equals("previous")) {

				pageNo = Integer.parseInt(request.getParameter("pageNo"));

				pageNo--;
			}

			List list = model.search(bean, pageNo, pageSize);

			request.setAttribute("list", list);

			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarkSheetListView.jsp");
		rd.forward(request, response);

	}
}