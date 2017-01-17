<%-- 
    Document   : homecasual
    Created on : 2017-jan-16, 16:18:49
    Author     : Johan Nilsson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AJ Car Rentals</title>
        <style type="text/css">
            p {
                color: white;
            }
            th {
                vertical-align: bottom;
            }
        </style>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#pickupdatepicker").datepicker();
            });
            $(function () {
                $("#dropoffdatepicker").datepicker();
            });
        </script>
    </head>
    <body>
        <div class="header">
            <table border="2">
                <thead>
                    <tr>
                        <th width="15%" >
                            <img src="Images/headerBackgrund.jpg" alt=""/>
                        </th>
                        <th width = "70%">
                            <label align ="center">AJ Car Rentals</label>
                        </th>
                        <th width = "15%"><a href="login.jsp" >Log IN</a></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td background="Images/road.jpg" height = "700">
                            <form action="showavilableCarsServlet" method="post">
                                <p class="main">
                                    Start Date: <input type="text" name ="pickupdate" id="pickupdatepicker" />
                                    Start Date: <input type="text"  name="dropoffdate" id="dropoffdatepicker" />
                                </p>
                                <br>
                                <br>
                                <input type="submit" name =checkcars" values="Check for cars"/>

                            </form>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>


        </div>
        <div class="sidebar">

        </div>
        <div class = "main">

        </div>
    </body>
</html>
