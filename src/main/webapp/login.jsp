
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body bgcolor="#deb887">
<h1 align="center"> Hello dear guest  </h1>
<h1 align="center"><em> You need to login to getting access the data</em> </h1>
<br/>
<h2 align="center">
<form action="/loginUser" method="post">
        Enter the username: <input align="center" type="text" name="uname"><br/>
        Enter the password: <input align="center" type="password" name="upass"><br/>
    <input align="center" type="submit" value="- Login -"><br/>
</form>
    <br/>
    <h3 align="center">Do not have an account?
    <p align="center"><a href="registration.jsp"> Click here ! </a> </p>
    </h3>
</h2>
</body>
</html>
