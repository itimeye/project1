package com.revature.web.jdbc;

public class Reimbursement {

	private int reimbId;
	private int empId;
	private String status;
	private int amount;
	
	
	public Reimbursement(int empId, int amount) {
		super();
		this.empId = empId;
		this.amount = amount;
	}


	public Reimbursement(int reimbId, int empId, String status, int amount) {
		super();
		this.reimbId = reimbId;
		this.empId = empId;
		this.status = status;
		this.amount = amount;
	}


	public int getReimbId() {
		return reimbId;
	}


	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}


	public int getempId() {
		return empId;
	}


	public void setempId(int empId) {
		this.empId = empId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", empEmail=" + empId + ", status=" + status + ", amount="
				+ amount + "]";
	}
	
			
}
