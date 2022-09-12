<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

	<title>Lony's Reimbursements</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

<div id="wrapper">
		<div id="header">
			<h2>Reimbursement Menu</h2>
		</div>
	</div>

<div id="container">

		<!-- View Pending Reimbursement -->
		<input type="button" value="View Pending Reimbursements"
			onclick="window.location.href='ReimbursementControllerServlet'; return false;"
			class = "view-pending-reimbursment-button"
		/>
		
		<!-- View Resolved Reimbursement -->
		<input type="button" value="View Resolved Reimbursements"
			onclick="window.location.href='ReimbursementResControllerServlet'; return false;"
			class = "view-resolved-reimbursment-button"
		/>
	</div>
	
	<div style="clear: both;"></div>
		
		<p>
			<a href="manager-main-menu.jsp">Back to Main Menu</a>
	
</div>

</body>

</html>