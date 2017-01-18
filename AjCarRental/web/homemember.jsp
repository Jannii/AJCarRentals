<%-- 
    Document   : homecasual
    Created on : 2017-jan-16, 16:18:49
    Author     : Johan Nilsson
--%>

<%@page import="Beans.statefulBean"%>
<%@page import="EntityBeans.Office"%>
<%@page import="EntityBeans.Car"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Beans.Userinfo"%>
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
            var location ;
            var map;
            var l ;
            
            function myMap() {

                var locations = [
                    ['Bondi Beach', -33.890542, 151.274856, 4],
                    ['Coogee Beach', -33.923036, 151.259052, 5],
                    ['Cronulla Beach', -34.028249, 151.157507, 3],
                    ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
                    ['Maroubra Beach', -33.950198, 151.259302, 1]
                ];

                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 1,
                    center: new google.maps.LatLng(0.0, 0.0),
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                });

                var infowindow = new google.maps.InfoWindow();

                var marker, i;

                for (i = 0; i < locations.length; i++) {
                    marker = new google.maps.Marker({
                        position: new google.maps.LatLng(locations[i][3], locations[i][4]),
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
            <table border="2">
                <thead>
                    <tr>
                        <th width="15%" >
                            <img src="Images/headerBackgrund.jpg" alt=""/>
                        </th>
                        <th width = "70%">
                            <label align ="center">AJ Car Rentals</label>
                        </th>
                        
                        <th width = "15%"> <%String s= statefulBean.getName();
                               out.print(s); %>
                        </th>
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
                                            <script>
                                                <%
                                                    List<Office> list = (List<Office>) request.getAttribute("Loc");
                                                    Iterator itr = list.iterator();
                                                    while (itr.hasNext()) {
                                                        Object[] obj = (Object[]) itr.next();
                                                        String id = String.valueOf(obj[0]);
                                                        String name = String.valueOf(obj[1]);
                                                        String address = String.valueOf(obj[2]);
                                                        String locX = String.valueOf(obj[3]);
                                                        String locY = String.valueOf(obj[4]);
                                                        String phone = String.valueOf(obj[5]);
                                                        System.out.println(locX);
                                                %>
                                                l.push(<%=id%>,<%=name%>,<%=address%>,<%=locX%>,<%=locY%>,<%=phone%>);
                                                location.push(l);
                                                for (int i = 0: i < location.size:i++)
                                                {
                                                    console.log("location" + location[0]);
                                                }

                                                <%}
                                                %>
                                                    
                                            </script>


                                            <div id="map" style="width:100%;height:500px"></div>
                                            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0GAEHADATv490rWxEHruelPDPFaWTqHc&callback=myMap"></script>
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
