<%-- 
    Document   : login
    Created on : Dec 17, 2018, 9:05:29 AM
    Author     : nikolaj, Victor

Description of file: Sida för att lägga till nytt event. Namn, datum, plats, pris och biljettantal anges

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
        </ul>
        <title>New Event</title>
    </head>
    <body>

        <header>
            <h1>New Event</h1>
        <form action="NewEventServlet" method="POST">
            <label>Event name</label><br>
            <input type="text" name="eventName" value="" /><br>
            <label>Date</label><br>
            <input type="text" name="date" value="" /><br>
            <label>Location</label><br>
            <input type="text" name="location" value="" /><br>
            <label>Price</label><br>
            <input type="text" name="price" value="" /><br>
            <label>Number of seats</label><br>
            <input type="text" name="seats" value="" /><br>
            <input type="submit" value="Add" name="submit" />
        </form>
        </header>

    </body>
</html>
