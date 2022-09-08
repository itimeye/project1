package com.revature.employee.jdbc;

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

import com.revature.web.jdbc.Reimbursement;
import com.revature.web.jdbc.ReimbursementDbUtil;



/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDbUtil employeeDbUtil;
	
	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		//create reimb db util & pass in conn pool/datasource
		try {
			employeeDbUtil = new EmployeeDbUtil(dataSource);
		}catch(Exception exc){
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
				listEmployee(request,response);break;
			case "LOAD":
				loadEmployee(request,response);break;
			case "UPDATE":
				updateEmployee(request,response);break;
			default:
				listEmployee(request,response);
			}
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
	}



	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		// read employee info from form
		int id = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		String password = request.getParameter("passowrd");
		String email = request.getParameter("email");
		
		// create a new student object
		Employee theEmployee = new Employee(empName, password, email);
		// perform update on database
		employeeDbUtil.updateEmployee(theEmployee);
		
		// send them back list info page
		listEmployee(request,response);
		
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//read emp id from data
		String theEmployeeId = request.getParameter("empId");
		
		// get student from database
		Employee theEmployee = employeeDbUtil.getEmployee(theEmployeeId);
		
		// place student in the request attribute
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		
		// send to jsp page
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-employee-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// get reimb from db util
		List<Employee> employees = employeeDbUtil.getEmployee();
		
		// add reimb to the request
		request.setAttribute("EMP_LIST", employees);
		
		//sent to JSP page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-information.jsp");
		dispatcher.forward(request, response);
		
	}

}
