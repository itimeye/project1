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
			<h2>Employee Information</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<input type="button" value="Add Employee"
			onclick="window.location.href='add-employee-form.jsp'; return false;"
			class = "add-student-button"
		/>
		
		<table>
		
			<tr>
			
				<th>Employee Id</th>
				<th>Employee Email</th>
				<th>Employee Name</th>
				<th>Employee Password</th>
				<th> Action </th>
			
			</tr>
			<c:forEach var="tempEmployee" items="${EMP_LIST }">
					<!-- Set up a link for update -->
					<c:url var="tempLink" value="EmployeeAllControllerServlet"> 
						<c:param name="command" value="LOAD"/>
						<c:param name="empId" value="${tempEmp.empId }" />
					</c:url>
					<!-- set up link for delete employee -->
				<c:url var="deleteLink" value="EmployeeAllControllerServlet">
					<c:param name ="command" value="DELETE"/>
					<c:param name="empId" value="${tempEmp.empId }"/>
				</c:url>	
				<tr>
					<td> ${tempEmployee.empId }</td>
					<td> ${tempEmployee.email }</td>
					<td> ${tempEmployee.empName }</td>
					<td> ${tempEmployee.password }</td>
					<td> 
						<a href="${tempLink }">Update</a>
						|
						<a href="${deleteLink }"
						onclick="if(!(confirm('Are you sure you want to delete this employee')))return false">
						Delete</a>
					</td>
				</tr>
			
			</c:forEach>
		</table>
		
		</div>
		<div style="clear: both;"></div>
		
		<p>
			<a href="employee-main-menu.jsp">Back to Main Menu</a>
	</div>

</body>

</html>