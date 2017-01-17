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

            function PickupMap() {
                var mapOptions = {
                    center: new google.maps.LatLng(45, 14),
                    zoom: 10,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
                var marker = new google.maps.Marker({
                position: myLatLng,
                map: map,
                title: 'Hello World!'
            });
            }
            
            function moveToLocation(lat, lng) {
                var center = new google.maps.LatLng(lat, lng);
                map.panTo(center);
            }
            $('#recenter').click(function () {
                moveToLocation(-34, 150);
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
                <tbody background="Images/road.jpg">
                    <tr>
                        <td></td>
                        <td>
                            <table border="4" width = "100%">
                                <form action="showavilableCarsServlet" method="post">
                                    <tr>
                                        <td width = "49%" height="50">

                                            <p>
                                                Pickup Date: <input type="text" name ="pickupdate" id="pickupdatepicker" />
                                            </p>
                                        </td>
                                        <td width = "49%" height = "50">
                                            <p>
                                                Dropof Date: <input type="text"  name="dropoffdate" id="dropoffdatepicker" />
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div id="map_canvas" style="width:100%;height:500px"></div>
                                            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0GAEHADATv490rWxEHruelPDPFaWTqHc&callback=PickupMap"></script>
                                        </td>
                                        <td>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="submit" name =checkcars" values="Check for cars"/></td>
                                        <td></td>
                                    </tr>
                                </form>

                            </table>
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
