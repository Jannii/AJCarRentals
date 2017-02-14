<%-- 
    Document   : ListBookings
    Created on : 2017-feb-14, 14:15:46
    Author     : Johan Nilsson
--%>

<%@page import="java.util.Iterator"%>
<%@page import="EntityBeans.Booking"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ListBookingsServlet" method="post">
            <table border="1">
                <%
                    List<Booking> l = (List<Booking>) request.getAttribute("Bookinglist");
                    Iterator itr = l.iterator();
                    while (itr.hasNext()) {
                        Object[] obj = (Object[]) itr.next();

                        int Bookingid = Integer.parseInt(String.valueOf(obj[0]));
                        String clientname = String.valueOf(obj[1]);
                        String clientadress = String.valueOf(obj[2]);
                        String clientmail = String.valueOf(obj[3]);
                        String clientPhone = String.valueOf(obj[4]);
                        String pstatus = String.valueOf(obj[5]);
                        String price = String.valueOf(obj[6]);
                        String bdate = String.valueOf(obj[7]);
                        String pdate = String.valueOf(obj[8]);
                        String ddate = String.valueOf(obj[9]);
                        String carid = String.valueOf(obj[10]);
                        String ploc = String.valueOf(obj[11]);
                        String dloc = String.valueOf(obj[12]);
                        String type = "";
                        if (pstatus.equals("true")) {
                            type = "display: none;";
                        } else {
                            type = "";
                        }

                %>
                <thead>
                    <tr>
                        <td>
                            <p>ID:</p>
                        </td>
                        <td>
                            <p>Client name:</p>
                        </td>
                        <td>
                            <p>Client address:</p>
                        </td>
                        <td>
                            <p>Client email:</p>
                        </td>
                        <td>
                            <p>Client phone:</p>
                        </td>
                        <td>
                            <p>Payment status:</p>
                        </td>
                        <td>
                            <p>Total price:</p>
                        </td>
                        <td>
                            <p>Booking date:</p>
                        </td>
                        <td>
                            <p>Pickup date:</p>
                        </td>
                        <td>
                            <p>Dropoff date:</p>
                        </td>
                        <td>
                            <p>Car id:</p>
                        </td>
                        <td>
                            <p>pickup location:</p>
                        </td>
                        <td>
                            <p>Dropoff location:</p>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <p><%=Bookingid%></p>
                        </td>
                        <td>
                            <p><%=clientname%></p>
                        </td>
                        <td>
                            <p><%=clientadress%></p>
                        </td>
                        <td>
                            <p><%=clientmail%></p>
                        </td>
                        <td>
                            <p><%=clientPhone%></p>
                        </td>
                        <td>
                            <p><%=pstatus%></p>
                        </td>
                        <td>
                            <p><%=price%></p>
                        </td>
                        <td>
                            <p><%=bdate%></p>
                        </td>
                        <td>
                            <p><%=pdate%></p>
                        </td>
                        <td>
                            <p><%=ddate%></p>
                        </td>
                        <td>
                            <p><%=carid%></p>
                        </td>
                        <td>
                            <p><%=ploc%></p>
                        </td>
                        <td>
                            <p><%=dloc%></p>
                        </td>
                        <td>
                            <div id="divCheckbox" style="<%=type%>">
                                <input type="submit" value="Pay this bill" name="<%=Bookingid%>">
                            </div>

                        </td>
                    </tr>
                </tbody>
                <%}%>
            </table>
        </form>
    </body>
</html>
