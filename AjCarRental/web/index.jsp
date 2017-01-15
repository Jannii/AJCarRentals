<%-- 
    Document   : index
    Created on : 2017-jan-15, 18:21:05
    Author     : Johan Nilsson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr>
        <h2>User credentials</h2>
        <form action="loginServlet" method="post">
            Username:
            <input type="text" name="username"><br><br>
            Password:
            <input type="password" name="password">
            <br><br>
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
