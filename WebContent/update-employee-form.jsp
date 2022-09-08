<!DOCTYPE html>

<html>

<head>

	<title>Update Employee Information</title>
	
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
		<h3>Update Employee Information</h3>
		
		<form action="EmployeeControllerServlet" method="GET">
		
		<input type="hidden" name="command" value="UPDATE"/>

		<input type="hidden" name="empId" value="${THE_EMPLOYEE.id }"/>
		
		<table>
			<tbody>
			
				<tr>
					<td><label>Employee Name:</label></td>
					<td><input type="text" name="firstName"
								value="${THE_EMPLOYEE.empName}"/> </td>
				</tr>
				<tr>
					<td><label>Employee Password:</label></td>
					<td><input type="number" name="amount"
								value="${THE_EMPLOYEE.password}"/> </td>
				</tr>
				<tr>
					<td><label>Employee Password:</label></td>
					<td><input type="number" name="amount"
								value="${THE_EMPLOYEE.email}"/> </td>
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