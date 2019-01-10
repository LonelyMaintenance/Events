<%-- 
    Document   : login
    Created on : Dec 17, 2018, 9:05:29 AM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>New Event</title>
    </head>
    <body>
        <form action="NewEventServlet" method="POST">
            Event name <input type="text" name="eventName" value="" /><br>
            Date <input type="text" name="date" value="" /><br>
            Location <input type="text" name="location" value="" /><br>
            Price <input type="text" name="price" value="" /><br>
            Number of seats  <input type="text" name="seats" value="" /><br>
            <input type="submit" value="Login" name="submit" />

        </form>

    </body>

</html>
