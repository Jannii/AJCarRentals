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
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
    <body>
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
                        <th width = "15%"><a href="login.jsp" >Log IN</a></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td>
                            <table border="0" width = "100%">
                                
                                <form action="showavilableCarsServlet" method="post">
                                    <tr>
                                        <td width = "49%" height="50">
                                            <p>
                                                Pickup Date: <input type="text" name ="pickupdate" id="pickupdatepicker" />
                                                Drop of Date: <input type="text"  name="dropoffdate" id="dropoffdatepicker" />
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width = "49%" height = "50">
                                            <p>
                                                
                                                Pickup Location: <select id="pickuploc" >
                                                    <option value="2">Malmö Office</option>
                                                    <option value="1">Kristianstad Office</option>
                                                </select>
                                            
                                                
                                                 Drop off Location: <select id="pickuploc" >
                                                    <option value="2">Malmö Office</option>
                                                    <option value="1">Kristianstad Office</option>
                                                </select>
                                            </p>
                                        </td>
                                        
                                    </tr>
                                    <tr>
                                        <td>

                                            <div id="map" style="width:100%;height:500px"></div>
                                            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0GAEHADATv490rWxEHruelPDPFaWTqHc&callback=myMap"></script>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="submit" name =checkcars" values="Check for cars"/></td>
                                    </tr>
                                </form>

                            </table>
                        </td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
