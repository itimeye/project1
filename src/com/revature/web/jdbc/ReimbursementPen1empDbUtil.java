package com.revature.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ReimbursementPen1empDbUtil {
	
	private DataSource dataSource;
	
	public ReimbursementPen1empDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Reimbursement> getReimb()throws Exception {
		
		List<Reimbursement> reimbursement = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from reimbursements"
					+" where (empId = 3) and (status = 'P')";
			
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int reimbId = myRs.getInt("reimbId");
				int amount = myRs.getInt("amount");
				String status = myRs.getString("status");
				
				Reimbursement tempReimb = new Reimbursement(reimbId, amount, status);
				
				reimbursement.add(tempReimb);
			}
			
			return reimbursement;
		}finally{
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs != null) {
				myRs.close();
			}
			if(myStmt != null) {
				myStmt.close();
			}
			if(myConn != null) {
				myConn.close();
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
