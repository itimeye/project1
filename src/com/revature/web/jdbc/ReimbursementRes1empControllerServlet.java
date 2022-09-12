package com.revature.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ReimbursementRes1empControllerServlet
 */
@WebServlet("/ReimbursementRes1empControllerServlet")
public class ReimbursementRes1empControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
	private ReimbursementRes1empDbUtil reimbursementRes1DbUtil;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			reimbursementRes1DbUtil = new ReimbursementRes1empDbUtil(dataSource);
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
			throw new ServletException(exc);
		}
	}



	private void listreimb1emp(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Reimbursement> reimbursement = ReimbursementRes1empDbUtil.getReimb();
		
		request.setAttribute("REIMB_LIST", reimbursement);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-1-Res-reimb-emp.jsp");
		dispatcher.forward(request, response);
		
	}

}
