<!DOCTYPE html>

<html>

<head>

	<title>Reimbursement Submission Page</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lony's Reimbursements</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Reimbursement Request</h3>
		
		<form action="ReimbursementControllerServlet" method="GET">
		
		<input type="hidden" name="command" value="ADD"/>
		
		<input type="hidden" name="empId" value="${THE_EMP.id }"/>
		
		<table>
			<tbody>
			
				<tr>
<!-- 					<td><label>Employee Id:</label></td>
					<td><input type="number" name="empId"/> </td>
				</tr>
				<tr> -->
					<td><label>Amount:</label></td>
					<td><input type="number" name="amount"/> </td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" name="Save" class="save"/> </td>
				</tr>
					
			</tbody>
		</table>
		
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="reimbursement-menu.jsp">Back to Main Menu</a>
	</div>
	
</body>

</html>