<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

	<title>Lony's Reimbursement Page</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

<div id="wrapper">
		<div id="header">
			<h2>Manager Main Menu</h2>
		</div>
	</div>

<div id="container">

	<div id ="content">
		<!-- Reimbursement  Page Button-->
		<input type="button" value="Reimbursement Page"
			onclick="window.location.href='manager-reimbursement-menu.jsp'; return false;"
			class = "reimbursement-menu-button"
		/>
		
		<!-- Information Page Button -->
		<input type="button" value="Information Page"
			onclick="window.location.href='manager-information-page.jsp'; return false;"
			class = "information-menu-button"
		/>
	</div>
	
</div>

</body>

</html>