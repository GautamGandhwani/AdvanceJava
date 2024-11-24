package co.in.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.in.Bean.UserBean;
import co.in.Model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("Operation = " + op);

		HttpSession session = request.getSession();

		if (op != null) {
			session.invalidate();

			request.setAttribute("msg", "Usre Logout Successfully");
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		System.out.println("Operation = " + op);

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		HttpSession session = request.getSession();

		String loginId = request.getParameter("loginId");
		String passWord = request.getParameter("passWord");

		if (op.equals("SignIn")) {
			try {
				bean = model.authenticate(loginId, passWord);

				if (bean != null) {
					session.setAttribute("user", bean);

					RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("err", "Invalid LoginId or Password");
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
