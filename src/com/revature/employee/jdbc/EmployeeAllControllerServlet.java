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

/**
 * Servlet implementation class EmployeeAllControllerServlet
 */
@WebServlet("/EmployeeAllControllerServlet")
public class EmployeeAllControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeAllDbUtil employeeAllDbUtil;
	
	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
	
    @Override
	public void init() throws ServletException {
		super.init();
		try {
			employeeAllDbUtil = new EmployeeAllDbUtil(dataSource);
		}catch(Exception exc) {
			throw new ServletException(exc);
		}
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			
			if(theCommand ==null) {
				theCommand = "LIST";
			}
			
			switch (theCommand) {
			case "LIST":
				listEmployee(request,response);break;
			case "ADD":
				addEmployee(request,response);break;
			case "LOAD":
				loadEmployee(request,response);break;
			case "UPDATE":
				updateEmployee(request,response);break;
			case "DELETE":
				deleteEmployee(request,response);break;
			default:
				listEmployee(request,response);
			}
			
		}catch(Exception exc) {
			throw new ServletException(exc);
	}

	
}


	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		String theEmployeeId = request.getParameter("empId");
		
		employeeAllDbUtil.deleteEmployee(theEmployeeId);
		
		listEmployee(request,response);
		
	}


	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String empName = request.getParameter("empName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Employee theEmployee = new Employee(empName, email, password);
		
		employeeAllDbUtil.addEmployee(theEmployee);
		
		listEmployee(request,response);
		
	}


	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Employee theEmployee = new Employee(empId, empName, email, password);
		
		employeeAllDbUtil.updateEmployee(theEmployee);
		
		listEmployee(request,response);
		
	}


	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String theEmployeeId = request.getParameter("empId");
		
		Employee theEmployee = employeeAllDbUtil.getEmployee(theEmployeeId);
		
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-all-employee-form.jsp");
		dispatcher.forward(request, response);
		
	}


	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Employee> employees = employeeAllDbUtil.getEmployee();
		
		request.setAttribute("EMP_LIST", employees);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-all-emp-information.jsp");
		dispatcher.forward(request, response);
		
	}
}
