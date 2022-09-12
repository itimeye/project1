package com.revature.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ReimbursementPen1empControllerServlet
 */
@WebServlet("/ReimbursementPen1empControllerServlet")
public class ReimbursementPen1empControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReimbursementPen1empDbUtil reimbursementPen1empDbUtil;
	
	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			reimbursementPen1empDbUtil = new ReimbursementPen1empDbUtil(dataSource);
		}catch(Exception exc){
			throw new ServletException(exc);
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand) {
			case"LIST":
				listreimb1emp(request,response);break;
			default:
				listreimb1emp(request,response);
			}
			
		}catch(Exception exc){
			
		}
	}



	private void listreimb1emp(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List<Reimbursement> reimb = reimbursementPen1empDbUtil.getReimb();
		
		request.setAttribute("REIMB_LIST", reimb);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-1-Pen-reimb-emp.jsp");
		dispatcher.forward(request, response);
	}

}
