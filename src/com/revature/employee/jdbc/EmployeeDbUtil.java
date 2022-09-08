package com.revature.employee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.revature.web.jdbc.Reimbursement;

	public class EmployeeDbUtil {
	
		private DataSource dataSource;
		
		public EmployeeDbUtil(DataSource theDataSource) {
			dataSource = theDataSource;
		}
	public List<Employee> getEmployee() throws Exception{
			
		List<Employee> employee = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			//get a connection
			myConn = dataSource.getConnection();
			
			//create sql statement
			String sql = "select * from employee where empId = 3";
			
			myStmt = myConn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			
			//process result set
			while (myRs.next()) {
				
				//retrieve data from result set row
				String email = myRs.getString("email");
				String empName = myRs.getString("empName");
				String password = myRs.getString("password");
				//create new Reimbursement object
				Employee tempEmp = new Employee(email, empName, password);
				
				// add it to the list of Reimbursements
				employee.add(tempEmp);
			}
						
				return employee;
			}finally {
				//close JDBC objects
				close(myConn, myStmt, myRs);
				}
		
	}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	public Employee getEmployee(String theEmployeeId) throws Exception{
		Employee theEmployee = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int empId;
		
		try {
			//convert student id to int
			empId = Integer.parseInt(theEmployeeId);
			
			//get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from employee where empId = 3";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, empId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if(myRs.next()) {
				String empName = myRs.getString("empName");
				String password= myRs.getString("password");
				String email = myRs.getString("emial");
				
				// use the empEmail during construction
				theEmployee = new Employee( empId, empName, email, password);
			}else {
				throw new Exception("Could not find Employee Email.");
			}
			
			return theEmployee;
			
		}finally {
			//close JDBC
			close(myConn, myStmt, myRs);
		}
		
		
	}
	public void updateEmployee(Employee theEmployee) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			//create sql update statement
			String sql = "update employee "
						+ "set empName = ?, password = ?, email = ? "
						+ "where id=?";
			
			//prepare statment
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, theEmployee.getEmpName());
			myStmt.setString(2, theEmployee.getPassword());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setInt(4, theEmployee.getEmpId());
			
			//execute sql statement
		myStmt.execute();
		}finally {
			close(myConn,myStmt,null);
		}
		
	}
		
}
