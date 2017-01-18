<%-- 
    Document   : adminpayment
    Created on : 2017-jan-17, 20:02:55
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
        <form action="${initParam['posturl']}" method="POST">
        <h1>PAY UP BITCH</h1>
        <input type="hidden" name="upload" value="1"/>
        <input type="hidden" name="return" value="${initParam['returnurl']}"/>
        <input type="hidden" name="cmd" value="_cart"/>
        <input type="hidden" name="business" value="${initParam['business']}"/>
        <INPUT type="hidden" name="currency_code" value=${initParam['currencycode']}>
        
        <input type="text" name="item_name_1" value="product 1"/>
        <input type="text" name="amount_1" value="10"/>
        <input type="text" name="quantity_1" value="1"/>
        <input type="submit" value="Payment"/>
        </form>
    </body>
</html>
