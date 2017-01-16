<%-- 
    Document   : login
    Created on : 2017-jan-16, 19:57:54
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
        <div class="header">
            <table border="2">
                <thead>
                    <tr>
                        <th width="15%">
                            <img src="Images/headerBackgrund.jpg" alt=""/>
                        </th>
                        <th width = "70%">
                            <label align ="center">AJ Car Rentals</label>
                        </th>
                        <th width = "15%"><a href="index.jsp" >Log IN</a></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td width="15%"></td>
                        <td width = "70%">
                            <h1>Login</h1>
                            <hr>
                            <h2>User credentials</h2>
                            <label>hej
                             </label>
                            <form action="loginServlet" method="post">
                                Username:
                                <input type="text" name="username"><br><br>
                                Password:
                                <input type="password" name="password">
                                <br><br>
                                <input type="submit" name="Submit">
                                <a href="addmember.jsp">Become member</a>
                            </form>

                        </td>
                        <td width="15%"></td>
                    </tr>
                </tbody>
            </table>


        </div>
    </body>
</html>
