<%-- 
    Document   : login
    Created on : 25 Aug, 2021, 8:48:37 AM
    Author     : raosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success Page</title>
    </head>
    <body>
        <h1>Hi <%= request.getAttribute("user") %>, Login successful </h1>
        <a href="login.html"> Login Page</a>
    </body>
</html>
