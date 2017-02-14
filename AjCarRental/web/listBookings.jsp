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
        <table>
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
            <tr>
                <td>
                    <p>ID: <%=Bookingid%></p>
                    <p>Client name: <%=clientname%></p>
                    <p>Client address: <%=clientadress%></p>
                    <p>Client email: <%=clientmail%></p>
                    <p>Client phone: <%=clientPhone%></p>
                    <p>Payment status: <%=pstatus%></p>
                    <p>Total price: <%=price%></p>
                    <p>Booking date: <%=bdate%></p>
                    <p>Pickup date: <%=pdate%></p>
                    <p>Dropoff date: <%=ddate%></p>
                    <p>Car id: <%=carid%></p>
                    <p>pickup location: <%=ploc%></p>
                    <p>Dropoff location: <%=dloc%></p>
                    <div id="divCheckbox" style="<%=type%>">
                        <input type="submit" value="Pay this bill" name="<%=Bookingid%>">
                    </div>

                </td>
                <td>

                </td>

                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>


            </tr>
            <%}%>
        </table>
        </form>
    </body>
</html>
