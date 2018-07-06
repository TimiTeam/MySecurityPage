
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body bgcolor="aqua">
<h1 align="center"> <em> Good to see a new users</em></h1><br/>

<h2 align="center"> <em> Here you can a create an account </em></h2>
<h2 align="center"> <em> Please fill in all fields </em></h2>
<h3 align="center">
<form action="/registrationUser" method="post">
<p>
  Enter your name. This will be your nickname.<br/>
  <input type="text" name="uname"><br/>

  Enter your last name. Its for more infomation about you.<br/>
  <input type="text" name="ulastname"><br/>

    Enter your login.<br/>
    <input type="text" name="login"> <br/>

    Enter your password.<br/>
    <input type="password" name="password"><br/>
    <input type="submit">
</p>
</form>
</h3>
</body>
</html>
