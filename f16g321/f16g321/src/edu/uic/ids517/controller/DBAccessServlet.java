package edu.uic.ids517.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uic.ids517.model.DBAccessBean;
//import edu.uic.ids517.model.DBAccessInfoBean;

/**
 * Servlet implementation class DBAccessServlet
 */
@WebServlet("/DBAccessServlet")
public class DBAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBAccessServlet() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
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
		// DBAccessInfoBean dBAccessInfoBean = (DBAccessInfoBean)
		// session.getAttribute("dBAccessInfoBean");
		System.out.println((String) request.getParameter("userName") +(String) request.getParameter("password")+
				(String) request.getParameter("dbms")+ (String) request.getParameter("dBSchema")+ (String) request.getParameter("dbmsHost"));
		DBAccessBean dBAccessBean = (DBAccessBean) session.getAttribute("dBAccessBean");
		dBAccessBean.loginInfo((String) request.getParameter("userName"), 
				(String) request.getParameter("password"), (String) request.getParameter("dbms"), 
				(String) request.getParameter("dBSchema"), (String) request.getParameter("dbmsHost"));
		//dBAccessBean.setUserName((String) request.getParameter("userName"));
		//dBAccessBean.setPassword((String) request.getParameter("password"));
		//dBAccessBean.setDbms((String) request.getParameter("dbms"));
		//dBAccessBean.setDbmsHost((String) request.getParameter("dbmsHost"));
		//dBAccessBean.setDBSchema((String) request.getParameter("dBSchema"));
		// dBAccessBean.setDBAccessInfoBean(dBAccessInfoBean);
		//System.out.println("request @@@@@@@@@@" + (String) session.getAttribute("userName"));
		String status = dBAccessBean.connect();
		if(status.equals("SUCCESS")){
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/databaseDisplay.jsp");
					dispatcher.forward(request, response);
		} else {
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/databaseLogin.jsp");
					dispatcher.forward(request, response);
		}
		

	}
}
