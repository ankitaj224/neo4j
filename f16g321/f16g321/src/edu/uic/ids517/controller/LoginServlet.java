package edu.uic.ids517.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import edu.uic.ids517.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession();
		LoginBean loginBean = (LoginBean) session.getAttribute("loginBean");

		loginBean.setUserName(request.getParameter("userName"));
		loginBean.setPassword(request.getParameter("password"));
		loginBean.setLastLoginTime(new Date());
		loginBean.setLastLoginIP(request.getRemoteAddr());
		// String pswd = request.getParameter("password");

		String status = loginBean.validate();

		if (status.equals("SUCCESS")) {
			if ((loginBean.getRole()).equals("Student")) {

				RequestDispatcher rd = request.getRequestDispatcher("/student.jsp");
				rd.forward(request, response);
			} else if (loginBean.getRole().equals("Instructor")) {
				RequestDispatcher rd = request.getRequestDispatcher("/instructor.jsp");
				rd.forward(request, response);
			} else if (loginBean.getRole().equals("Admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("/databaseLogin.jsp");
				rd.forward(request, response);
			} else {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);

			}

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}

	}
}
