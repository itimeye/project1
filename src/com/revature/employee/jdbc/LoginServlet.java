package com.revature.employee.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDao loginDao;
	
	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		try {
			loginDao = new LoginDao(dataSource);
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
        request.getRequestDispatcher("login.jsp").include(request,response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
			
//			theLogin(request,response);
////			theEmployee.setEmail(email);
////			theEmployee.setPassword(password);
									
//		}catch(Exception exc) {
//			throw new ServletException(exc);
//		}
		
		String theEmpE = request.getParameter("email");
		String theEmpP = request.getParameter("password");
		String isM = request.getParameter("isManager");
		String empId = request.getParameter("emdId");
		
		Employee theEmployee = new Employee(theEmpE, theEmpP, isM, empId);
		
//		Employee theEmployeeEmail = loginDao.getEmail(theEmpE);
//		Employee theEmployeePassword = loginDao.getPassword(theEmpP);
		
		
//		request.setAttribute("THE_EMP", theEmployeeEmail);
//		request.setAttribute("THE_EMP", theEmployeePassword);
		
//		RequestDispatcher dispatcher =
//				request.getRequestDispatcher("/login.jsp");
		
		if( theEmployee.getEmail().equals("email") && theEmployee.getPassword().equals("password")) {
			Cookie cookie = new Cookie("lonys.Login",empId);
			response.addCookie(cookie);
			
			if(theEmployee.getIsManager().equals("Y")) {
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("manager-main-menu.jsp");
						dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("employee-main-menu.jsp");
						dispatcher.forward(request, response);
			}
		}
	
	}
//

	private void theLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {}
		
	
}
