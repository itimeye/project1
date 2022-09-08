package com.revature.employee.jdbc;

public class Employee {
	private int empId;
	private String email;
	private String empName;
	private String password;
	private String isManager;
	
	
	
	
	public Employee(int empId, String email, String empName, String password) {
		super();
		this.empId = empId;
		this.email = email;
		this.empName = empName;
		this.password = password;
	}

	public Employee(String email, String empName, String password) {
		this.email = email;
		this.empName = empName;
		this.password = password;
	}

	public Employee() {
		
	}
	
	public Employee(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Employee(String email, String empName, String password, String isManager) {
		super();
		this.email = email;
		this.empName = empName;
		this.password = password;
		this.isManager = isManager;
	}
	
	public Employee(String email) {
		this.email = email;
	}

	public Employee(int empId, String email, String isManager) {
		this.empId = empId;
		this.email = email;
		this.isManager = isManager;
	}

	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIsManager() {
		return isManager;
	}


	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}


	@Override
	public String toString() {
		return "Employee [email=" + email + ", empName=" + empName + ", password=" + password + ", isManager="
				+ isManager + "]";
	}


	public Employee checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void getEmpId(int empId2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
