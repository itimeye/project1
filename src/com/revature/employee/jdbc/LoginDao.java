package com.revature.employee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;



public class LoginDao {
	
	private DataSource dataSource;
	public LoginDao(DataSource theDataSource) {
		dataSource = theDataSource;
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
    
	

	public Employee getlogin(Employee theEMP)throws Exception {
		Employee theEmployee = null;
		String theEmpLog = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		
		
		try {
			
			
			myConn = dataSource.getConnection();
			
			String sql = "select * from employee where email = ? and password = ?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theEMP.getEmail());
			myStmt.setString(2, theEMP.getPassword());
			
			myRs = myStmt.executeQuery();
			
			myRs.next();
			
			String empEmail = myRs.getString("email");
			String password = myRs.getString("password");
			String isManager = myRs.getString("isManager");
			int empId = myRs.getInt("empId");
			
			theEmployee = new Employee(empId,empEmail, password, isManager );
			
			return theEmployee;
			
		}finally {
			close(myConn, myStmt, myRs);
		}
	}



	public Employee getloginp(Employee theEMPP) {
		// TODO Auto-generated method stub
		return null;
	}



	public Employee getEmail(String theEmpE) throws Exception {
		Employee theEmployeeE = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String ee = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from employee where email = ?";
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, ee);
			
			myRs = myStmt.executeQuery();
			
			myRs.next();
			String email = myRs.getString("email");
			String password = myRs.getString("password");
			String isManager = myRs.getString("isManager");
			int empId = myRs.getInt("empId");
			
			
			theEmployeeE = new Employee(empId, email,password, isManager);
			
			return theEmployeeE;
			
		}finally {
			close(myConn, myStmt, myRs);
		}
	}



//	public Employee getPassword(String theEmpP) throws Exception {
//		Employee theEmployeeP = null;
//		
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		ResultSet myRs = null;
//		String ep = null;
//		
//		try {
//			myConn = dataSource.getConnection();
//			
//			String sql = "select * from employee where password = ?";
//			
//			myStmt = myConn.prepareStatement(sql);
//			
//			myStmt.setString(1, ep);
//			
//			myRs = myStmt.executeQuery();
//			
//			myRs.next();
//			String email = myRs.getString("password");
//			
//			theEmployeeP = new Employee(email);
//			
//			return theEmployeeP;
//			
//		}finally {
//			close(myConn, myStmt, myRs);
//		}
//	}

}
