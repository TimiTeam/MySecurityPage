
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body bgcolor="#ffb6c1">
<%
  response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

  if(session.getAttribute("key")==null){
  response.sendRedirect("login.jsp");
  }
%>


<h1 align="center">Welcome!!</h1>
<br/>

<iframe align="center" width="560" height="315"
        src="https://www.youtube.com/embed/xLNeZogTsK8"
        frameborder="0"
        allow="autoplay; encrypted-media"
        allowfullscreen>

</iframe>
<br/>
<br/>
<h2 align="center">
  <form action="/logout" method="post">
    <input type="submit" value="logout">
  </form>
</h2>

</body>
</html>
