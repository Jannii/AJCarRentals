<%-- 
    Document   : ListCars
    Created on : 2017-jan-17, 15:06:56
    Author     : Johan Nilsson
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="EntityBeans.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                   <%
           
            List<Car> l = (List<Car>) request.getAttribute("Carlist");
            Iterator itr = l.iterator();
            while (itr.hasNext()) {
                Object[] obj = (Object[]) itr.next();
                
                int service = Integer.parseInt(String.valueOf(obj[0]));
                String name = String.valueOf(obj[1]);
                String type = String.valueOf(obj[2]);
                String home = String.valueOf(obj[3]);
                String Location = String.valueOf(obj[4]);
                %>
                <tr>
                    
                    <td>
                            <img src="Images/volvov40.jpg" alt=""/>
                    </td>
                    <td>
                        <p><% out.print(name); %><p>
                    </td>

                </tr>
                <%    
            }
        %>

            </tbody>
        </table>


        

    </body>
</html>
