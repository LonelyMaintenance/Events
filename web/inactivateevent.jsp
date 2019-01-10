<%-- 
    Document   : inactivateevent
    Created on : Jan 10, 2019, 9:32:25 AM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inactivate event</title>
    </head>
    <body>
        <h1>Event is no longer possible to attend</h1>
        <form action="InactivateEventServlet" method="POST">
            Event name <input type="text" name="eventName" value="" /><br>
            <input type="submit" value="Ok" name="submit" />
        </form>
    </body>
</html>
