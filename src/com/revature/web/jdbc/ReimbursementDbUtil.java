package com.revature.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.revature.employee.jdbc.Employee;

public class ReimbursementDbUtil {

	private DataSource dataSource;
	
	public ReimbursementDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Reimbursement> getReimb() throws Exception{
		
		List<Reimbursement> reimbs = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		//get a connection
		myConn = dataSource.getConnection();
		
		//create sql statement
		String sql = "select * from reimbursements where status = 'P'";
		
		myStmt = myConn.createStatement();
		
		//execute query
		myRs = myStmt.executeQuery(sql);
		
		//process result set
		while (myRs.next()) {
			
			//retrieve data from result set row
			int reimbId = myRs.getInt("reimbId");
			int empId = myRs.getInt("empId");
			String status = myRs.getString("status");
			int amount = myRs.getInt("amount");
			
			//create new Reimbursement object
			Reimbursement tempReimb = new Reimbursement(reimbId, empId, status, amount);
			
			// add it to the list of Reimbursements
			reimbs.add(tempReimb);
		}
					
			return reimbs;
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

	public void addReimb(Reimbursement theReimbursement, String theEmpId)throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		int empId;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into reimbursements "
					   + "(empId, amount) "
					   + "values (?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			//convert emp ID to int
			empId = Integer.parseInt(theEmpId);
			// set the param values for the student
			myStmt.setInt(1, theReimbursement.getempId());
			myStmt.setInt(2, theReimbursement.getAmount());
					
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}		
	}
	
	public List<Reimbursement> getRReimb() throws Exception{
		List<Reimbursement> reimbs = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
		//get a connection
		myConn = dataSource.getConnection();
		
		//create sql statement
		String sql = "SELECT * FROM reimbursements"
				+ "where (status = 'A' or status ='D') and empId = 1";
		
		myStmt = myConn.createStatement();
		
		//execute query
		myRs = myStmt.executeQuery(sql);
		
		//process result set
		while (myRs.next()) {
			
			//retrieve data from result set row
			int reimbId = myRs.getInt("reimbId");
			int empId = myRs.getInt("empId");
			String status = myRs.getString("status");
			int amount = myRs.getInt("amount");
			
			//create new Reimbursement object
			Reimbursement tempReimb = new Reimbursement(reimbId, empId, status, amount);
			
			// add it to the list of Reimbursements
			reimbs.add(tempReimb);
		}
					
			return reimbs;
		}finally {
			//close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
	}

	
	
	
}
