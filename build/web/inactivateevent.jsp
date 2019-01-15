<%-- 
    Document   : inactivateevent
    Created on : Jan 10, 2019, 9:32:25 AM
    Author     : nikolaj, Victor

Description of file: Sida för att ställa in event - användaren skriver in namnet på det event som ska ställas in

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
            <ul><a href="adminmenu.jsp">Menu</a></ul>            

                </ul>
        <title>Inactivate Event</title>
    </head>
    <body>

        <header>
            <h1>Cancel Event</h1>
        <form action="InactivateEventServlet" method="POST">
            <label>Event name</label><br> 
            <input type="text" name="eventName" value="" /><br>
            <input type="submit" value="Ok" name="submit" />
        </form>
        </header>

    </body>
</html>
