<%-- 
    Document   : homecasual
    Created on : 2017-jan-16, 16:18:49
    Author     : Johan Nilsson
--%>

<%@page import="EntityBeans.Office"%>
<%@page import="EntityBeans.Car"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AJ Car Rentals</title>
        <style type="text/css">
            p {
                color: black;
            }
            th {
                vertical-align: bottom;
            }
        </style>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" type="text/javascript"></script>
        <script>
            $(function () {
                $("#pickupdatepicker").datepicker();
            });
            $(function () {
                $("#dropoffdatepicker").datepicker();
            });
            var location;
            var map;
            var l;

            function myMap() {

                var locations = [
                    ['Malmö Office', 55.5985038, 12.970319199999949, 1],
                    ['Kristianstad Office', 56.0282729, 14.156845833333334, 1],
                ];

                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 5,
                    center: new google.maps.LatLng(59.3293235, 18.068580800000063),
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                });

                var infowindow = new google.maps.InfoWindow();

                var marker, i;

                for (i = 0; i < locations.length; i++) {
                    marker = new google.maps.Marker({
                        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                        map: map
                    });

                    google.maps.event.addListener(marker, 'click', (function (marker, i) {
                        return function () {
                            infowindow.setContent(locations[i][0]);
                            infowindow.open(map, marker);
                        }
                    })(marker, i));
                }
            }




        </script>
    </head>
    <body >
        <div class="header">
            <table border="1">
                <thead>
                    <tr>
                        <th width="15%" >
                            <img src="Images/headerBackgrund.jpg" alt=""/>
                        </th>
                        <th width = "70%">
                            <label align ="center">AJ Car Rentals</label>
                        </th>

                        <th width = "15%" >
                            <p>
                                Grettings o mighty <%=request.getAttribute("Username")%></br>
                                <a href="homecasual.jsp">Logout</a>

                            </p>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td>
                            <ul>
                                
                                <li><a href="">Add/Modify users</a></li>
                                form
                                <li><a href="/ListBookingsServlet">Check Bookings</li>
                            </ul>
                            </form>
                        </td>
                        <td></td>


                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
