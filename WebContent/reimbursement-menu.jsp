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

	<div id ="content">
		<!-- Submit Reimbursement  Page Button-->
		<input type="button" value="Submit Reimbursement"
			onclick="window.location.href='submit-reimbursement-form.jsp'; return false;"
			class = "submit-reimbursement-button"
		/>
		
		<!-- View Pending Reimbursement -->
		<input type="button" value="View Pending Reimbursement"
			onclick="window.location.href='ReimbursementPen1empControllerServlet'; return false;"
			class = "view-pending-reimbursment-button"
		/>
		
		<!-- View Resolved Reimbursement -->
		<input type="button" value="View Resolved Reimbursement"
			onclick="window.location.href='ReimbursementRes1empControllerServlet'; return false;"
			class = "view-resolved-reimbursment-button"
		/>
	</div>
	
	<div style="clear: both;"></div>
		
		<p>
			<a href="employee-main-menu.jsp">Back to Main Menu</a>
	
</div>

</body>

</html>