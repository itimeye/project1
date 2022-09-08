package com.revature.web.jdbc;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//define datasource/connection pool for resource injection
	@Resource(name="jdbc/test-project1")
	private DataSource dataSource;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set up printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		//get connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			// create a sql statment
			String sql = "select * from employee";
			myStmt = myConn.createStatement();
		
			// execute sql query
			myRs = myStmt.executeQuery(sql);
		
			// process result set
			while (myRs.next()) {
				String empName = myRs.getString("empName");
				out.println(empName);
			}
			
		}catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
}	
















