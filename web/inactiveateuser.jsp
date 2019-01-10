<%-- 
    Document   : inactiveateuser
    Created on : Jan 10, 2019, 9:29:18 AM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Inactive</title>
    </head>
    <body>
        <h1>Set user as no longer active</h1>
        <form action="InactivateUserServlet" method="POST">
            Email <input type="text" name="email" value="" /><br>
            <input type="submit" value="Ok" name="submit" />
        </form>
    </body>
</html>
