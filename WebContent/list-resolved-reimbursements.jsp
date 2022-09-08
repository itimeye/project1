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
			<h2>Resolved Reimbursements</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		<input type="hidden" name="command" value="LIST"/>
		
		<table>
		
			<tr>
			
				<th>Reimbursement ID</th>
				<th>Employee Email</th>
				<th>Status</th>
				<th>Amount</th>
			
			</tr>
			<c:forEach var="tempReimbursement" items="${REIMB_LIST }">
						
				<tr>
					<td> ${tempReimbursement.reimbId }</td>
					<td> ${tempReimbursement.empId }</td>
					<td> ${tempReimbursement.status }</td>
					<td> ${tempReimbursement.amount }</td>
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