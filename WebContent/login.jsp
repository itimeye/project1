<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<a href="login.jsp">Login</a> | <a href="LogoutServlet">Logout</a> 	
	<title>Lony's Reimbursements</title>
</head>

<body>
<form action="LoginServlet" method="POST">

	<div>
        <label>Employee Email</label>
        <input type="text" name="email" id="email"
        		value="${THE_EMP.email }"/>
    </div>
    <div>
        <label>Password</label>
        <input type="text" name="password" id="password"
        		value="${THE_EMP.password }"/>
    </div>
    <input type="submit" value="Login">

</form>

</body>

</html>