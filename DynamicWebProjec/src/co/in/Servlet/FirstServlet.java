package co.in.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse responsep) throws ServletException, IOException {

		System.out.println("In Do Get Method");
		responsep.sendRedirect("First.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In Do Post Method");
		System.out.println(request.getParameter("firstName"));
		System.out.println(request.getParameter("lastName"));
		System.out.println(request.getParameter("loginId"));
		System.out.println(request.getParameter("passWord"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("dob"));
		
		
	}

	
	
}
