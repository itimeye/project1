package com.revature.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ReimbursementResDbUtil {
	
	private DataSource dataSource;
	
	public ReimbursementResDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Reimbursement> getReimb() throws Exception{
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "SELECT * FROM reimbursements "
					+ "where (status = 'A' or status ='D')";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int reimbId = myRs.getInt("reimbId");
				int empId = myRs.getInt("empId");
				String status = myRs.getString("status");
				int amount = myRs.getInt("amount");
				
				Reimbursement tempReimb = new Reimbursement(reimbId, empId, status, amount);
				
				reimbursements.add(tempReimb);
				
		}
			return reimbursements;
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
			
		}catch(Exception exc){
			exc.printStackTrace();
		}		
	}


}
