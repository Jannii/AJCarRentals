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
        <title>AJ Car Rentals</title>
        <style>
            body {
                background-image: url("Images/road.jpg");
                background-color: b;
                background-repeat: no-repeat;
                background-position: center;
                background-size: 1000px 1000px;

            }
            input{
                margin:auto;
                display:block;
            }

            /* BUTTON STYLES */
            input{
                padding:16px 32px;
                font-family:helvetica;
                font-size:16px;
                font-weight:100;
                color:#fff;
                background: #587286;
                border:0;
                font-weight:100;
            }
            input:hover{
                background: #3B5C76;
            }
        </style>
    </head>
    <body >
        
        <form action="contServlet" method="POST" ">
            <h1 align="center" valign="middle">Welcome to AJ CarRentals</h1>
            <input type="submit" name="cont" value="Continue" valign="middle"/>

        </form>
    </body>
</html>
