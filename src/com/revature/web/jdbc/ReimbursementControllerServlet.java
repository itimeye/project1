package com.revature.web.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


import com.revature.employee.jdbc.Employee;
import com.revature.employee.jdbc.EmployeeDbUtil;

/**
 * Servlet implementation class ReimbursementControllerServlet
 */
@WebServlet("/ReimbursementControllerServlet")
public class ReimbursementControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReimbursementDbUtil reimbursementDbUtil;
	
	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
		
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create reimb db util & pass in conn pool/datasource
		try {
			reimbursementDbUtil = new ReimbursementDbUtil(dataSource);
		}catch(Exception exc){
			throw new ServletException(exc);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//read the command
			String theCommand = request.getParameter("command");
			//if command is missing, default to listing students
			if(theCommand == null) {
				theCommand = "LIST";
			}
			//route to the correct piece of code
			switch (theCommand) {
			case "LIST":
				listReimb(request,response);break;
			case "ADD":
				addReimb(request,response);break;
			case "APPROVE":
				approveReimbursement(request,response);break;
			case "DENY":
				denyReimbursement(request,response);break;
			default:
				listReimb(request,response);
			}
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	
	private void denyReimbursement(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		// read student id from form data
		String theReimbursementId = request.getParameter("reimbursementId");
		
		// deny student from database
		reimbursementDbUtil.denyReimb(theReimbursementId);
		
		//send them back to "list students page"
		listReimb(request,response);
		
	}


	private void approveReimbursement(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		// read student id from form data
		String theReimbursementId = request.getParameter("reimbursementId");
		
		// approve student from database
		reimbursementDbUtil.approveReimb(theReimbursementId);
				
		//send them back to "list students page"
		listReimb(request,response);
	}


	private void addReimb(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// read student info from form data
		int reimbId = Integer.parseInt(request.getParameter("ReimbursementId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		
		//create a new student object
		Reimbursement theReimbursement = new Reimbursement(reimbId,amount);
		
		// add the student to the database
		reimbursementDbUtil.addReimb(theReimbursement);
		
		//send back to main page
		listReimb(request,response);
		
	}


	private void listReimb(HttpServletRequest request, HttpServletResponse response) 
		throws Exception{
		// get reimb from db util
		List<Reimbursement> reimbursements = reimbursementDbUtil.getReimb();
		
		// add reimb to the request
		request.setAttribute("REIMB_LIST", reimbursements);
		
		//sent to JSP page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-pending-reimbursements.jsp");
		dispatcher.forward(request, response);
	}
	
	

}


