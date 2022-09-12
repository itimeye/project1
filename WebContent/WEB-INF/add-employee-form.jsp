<!DOCTYPE html>

<html>

<head>

	<title>Add New Employee</title>
	
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
		<h3>Add New Employee</h3>
		
		<form action="EmployeeAllControllerServlet" method="GET">
		
		<input type="hidden" name="command" value="ADD"/>
		
		<table>
			<tbody>
			
				<tr>
					<td><label>Employee Name:</label></td>
					<td><input type="text" name="empName"/> </td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input type="text" name="email"/> </td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="text" name="password"/> </td>
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
			<a href="EmployeeAllControllerServlet">Back to List</a>
	</div>
	
</body>

</html>