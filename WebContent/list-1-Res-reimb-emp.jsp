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
			<h2>Your Resolved Reimbursement Requests</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<table>
		
			<tr>
			
				<th>Reimbursement Id</th>
				<th>Amount</th>
				<th>Status</th>
			
			</tr>
			<c:forEach var="tempReimbursement" items="${REIMB_LIST }">
					<!-- Set up a link for update -->	
				<tr>
					<td> ${tempReimb.reimbId }</td>
					<td> ${tempReimb.amount }</td>
					<td> ${tempReimb.status }</td>
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