<%-- 
    Document   : AddMember
    Created on : 2017-jan-16, 16:23:29
    Author     : Johan Nilsson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Member</title>
    </head>
    <body>
        <form action="addmemberServlet" method="post">
            Username:
            <input type="text" name="username">
            <br><br>
            Password:
            <input type="password" name="password">
            <br><br>
            Name:
            <input type="text" name="name">
            <br><br>
            Adress:
            <input type="text" name="adress">
            <br><br>
            Email:
            <input type="email" name="email">
            <br><br>
            Phone:
            <input type="phone" name="phone">
            <br><br>
            <input type="submit" name="Submit">
        </form>
    </body>
</html>
