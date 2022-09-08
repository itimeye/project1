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
 * Servlet implementation class ReimbursementPenControllerServlet
 */
@WebServlet("/ReimbursementPenControllerServlet")
public class ReimbursementResControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReimbursementResDbUtil reimbursementResDbUtil;
	
	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
		
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			reimbursementResDbUtil = new ReimbursementResDbUtil(dataSource);
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
			
			switch (theCommand) {
			case "LIST":
				listReimb(request,response);break;
			case "ADD":
				addReimb(request,response);break;
			
			}
			
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
	}



	private void addReimb(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}



	private void listReimb(HttpServletRequest request, HttpServletResponse response) 
		throws Exception{
		List<Reimbursement> reimbursements = reimbursementResDbUtil.getReimb();
		
		request.setAttribute("REIMB_LIST", reimbursements);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-resolved-reimbursements.jsp");
		dispatcher.forward(request, response);
	}

}
