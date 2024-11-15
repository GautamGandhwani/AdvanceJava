package co.in.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.in.Bean.UserBean;
import co.in.Model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("UserRegistrationView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String loginId = request.getParameter("loginId");
		String passWord = request.getParameter("passWord");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");

		try {

			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(loginId);
			bean.setPassWord(passWord);
			bean.setAddress(address);
			bean.setDob(sdf.parse(dob));

			model.add(bean);
			
			request.setAttribute("msg", "User Registration Successfully.");
			
			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
			
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
