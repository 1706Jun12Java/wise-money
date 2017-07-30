<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New Account</title>
</head>
<body>
	<h1>Registration Form</h1>
    <form action="register" method="post">
        <table cellpadding="3pt">
            <tr>
                <td>First name:</td>
                <td><input type="text" name="firstName" size="30" /></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><input type="text" name="lastName" size="30" /></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName" size="30" /></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><input type="password" name="password" size="30" /></td>
            </tr>
            <tr>
                <td>email :</td>
                <td><input type="text" name="email" size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="Register" />
    </form>
</body>

</body>
</html>