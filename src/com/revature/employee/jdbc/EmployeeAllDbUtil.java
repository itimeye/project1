package com.revature.employee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeAllDbUtil {
	
	private DataSource dataSource;
	
	public EmployeeAllDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Employee> getEmployee() throws Exception {
		List<Employee> employee = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from employee";
			
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int empId = myRs.getInt("empId");
				String email = myRs.getString("email");
				String empName = myRs.getString("empName");
				String password = myRs.getString("password");
				
				Employee tempEmp = new Employee(empId,email, empName, password);
				
				employee.add(tempEmp);
			}
			return employee;
			
		}finally {
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
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

	public void addEmployee(Employee theEmployee)throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "insert into employee "
					+"(empName, email, password)"
					+" values (?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theEmployee.getEmpName());
			myStmt.setString(2, theEmployee.getEmail());
			myStmt.setString(3, theEmployee.getPassword());
			
			myStmt.execute();
		}finally {
			close(myConn,myStmt,null);
		}
		
	}

	public Employee getEmployee(String theEmployeeId)throws Exception{
		
		Employee theEmployee = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int empId;
		
		try {
			empId = Integer.parseInt(theEmployeeId);
			
			myConn = dataSource.getConnection();
			
			String sql = "select * from employee where id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, empId);
			
			myRs = myStmt.executeQuery();
			
			if(myRs.next()) {
				String empName = myRs.getString("empName");
				String email = myRs.getString("email");
				String password = myRs.getString("password");
				
				theEmployee = new Employee(empId, empName, email,password);
			}else {
				throw new Exception("could not find employee id: " + empId);
			}
			return theEmployee;
		}finally {
			close(myConn, myStmt, myRs);
		}
		
		
		
	}

	public void updateEmployee(Employee theEmployee) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "update employee "
						+"set empName=?, email=?, password=?"
						+" where id = ?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theEmployee.getEmpName());
			myStmt.setString(2, theEmployee.getEmail());
			myStmt.setString(3, theEmployee.getPassword());
			myStmt.setInt(4, theEmployee.getEmpId());
			
			myStmt.execute();
			
		}finally {
			close(myConn,myStmt,null);
		}
		
	}

	public void deleteEmployee(String theEmployeeId) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			int empId = Integer.parseInt(theEmployeeId);
			
			myConn = dataSource.getConnection();
			
			String sql = "delete from employee where id=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, empId);
			
			myStmt.execute();
			
		}finally {
			close(myConn,myStmt,null);
		}
		
	}

}
