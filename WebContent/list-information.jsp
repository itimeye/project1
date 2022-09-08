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
		
		<table>
		
			<tr>
			
				<th>Employee Email</th>
				<th>Employee Name</th>
				<th>Employee Password</th>
				<th> Update </th>
			
			</tr>
			<c:forEach var="tempEmployee" items="${EMP_LIST }">
					<!-- Set up a link for update -->
					<c:url var="tempLink" value="EmployeeControllerServlet"> 
						<c:param name="command" value="LOAD"/>
						<c:param name="empId" value="${tempEmp.id }" />
					</c:url>	
				<tr>
					<td> ${tempEmployee.email }</td>
					<td> ${tempEmployee.empName }</td>
					<td> ${tempEmployee.password }</td>
					<td> <a href="${tempLink }">Update</a></td>
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