<%-- 
    Document   : confirmPurchase
    Created on : 2017-jan-18, 17:34:31
    Author     : bumblebee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Confirm purchase</h1>

        <%
            out.println("Carmodel: " + request.getAttribute("carName"));
        %>
        <br>
        <%
            out.println("Cartype: " + request.getAttribute("carType"));
        %>
        <br>
        <%
            out.println("car home: " + request.getAttribute("carHome"));
        %>
        <br>
        <%
            out.println("car location: " + request.getAttribute("carLocation"));
        %>
        <br>
        <%
            out.println("Pick up date: " + request.getAttribute("pickUpDate"));
        %>
        <br>
        <%
            out.println("Drop of date: " + request.getAttribute("dropOdDate"));
        %>
        <br>
        <%
            out.println("Total pricee: " + request.getAttribute("carPrice"));
        %>
        <br>
        <form action="${initParam['posturl']}" method="POST">
            <%
            String price = request.getAttribute("carPrice").toString();
            String carName = request.getAttribute("carName").toString();
            %>
            Your Name: <input type="Text"/><br>
            Your Adress:<input type="Text"/><br>
            Your Email:<input type="Text"/><br>
            Your Phone<input type="Text"/><br>
        <h1>PAY UP BITCH</h1>
        <input type="hidden" name="upload" value="1"/>
        <input type="hidden" name="return" value="${initParam['returnurl']}"/>
        <input type="hidden" name="cmd" value="_cart"/>
        <input type="hidden" name="business" value="${initParam['business']}"/>
        <INPUT type="hidden" name="currency_code" value=${initParam['currencycode']}>
        
        <input type="hidden" name="item_name_1" value="<%=carName%>"/>
        <input type="hidden" name="amount_1" value="<%=price%>"/>
        <input type="hidden" name="quantity_1" value="1"/>
        <input type="submit" value="Payment"/>
        </form>

    </body>
</html>
