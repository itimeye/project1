<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

	<title>Lony's Reimbursements Tracker</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Pending Reimbursements</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<table>
		
			<tr>
			
				<th>Reimbursement ID</th>
				<th>Employee Email</th>
				<th>Status</th>
				<th>Amount</th>
				<th>Action</th>
			
			</tr>
			<c:forEach var="tempReimbursement" items="${REIMB_LIST }">
				<!-- set up link for approve each student -->
				<c:url var="approveLink" value="ReimbursementControllerServlet">
					<c:param name ="command" value="APPROVE"/>
					<c:param name="reimbursementId" value="${tempReimbursement.reimbId }"/>
				</c:url>
				<!-- set up link for deny student -->
				<c:url var="denyLink" value="ReimbursementControllerServlet">
					<c:param name ="command" value="DENY"/>
					<c:param name="reimbursementId" value="${tempReimbursement.reimbId }"/>
				</c:url>
				
				<tr>
					<td> ${tempReimbursement.reimbId }</td>
					<td> ${tempReimbursement.empId }</td>
					<td> ${tempReimbursement.status }</td>
					<td> ${tempReimbursement.amount }</td>
					<td>
						<a href ="${approveLink }"
						onclick="if(!(confirm('Are you sure you want to approve this reimbursement')))return false">
						Approve</a>
						|
						<a href ="${denyLink }"
						onclick="if(!(confirm('Are you sure you want to deny this reimbursement')))return false">
						Deny</a>		
					</td>
				</tr>
			
			</c:forEach>
		</table>
		
		</div>
		<div style="clear: both;"></div>
		
		<p>
			<a href="reimbursement-menu.jsp">Back to Reimbursement Menu</a>
	</div>

</body>

</html>