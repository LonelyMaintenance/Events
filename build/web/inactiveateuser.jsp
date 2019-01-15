<%-- 
    Document   : inactiveateuser
    Created on : Jan 10, 2019, 9:29:18 AM
    Author     : nikolaj, Victor

Description of file: Sida för att avregistrera användare - admin anger e-postadress hos användaren

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
        <title>Inactivate User</title>
    </head>
    <body>

        <header>
            <h1>Set user as no longer active</h1>
        <form action="InactivateUserServlet" method="POST">
            <label>User email</label><br> 
            <input type="text" name="email" value="" /><br>
            <input type="submit" value="Ok" name="submit" />
        </form>
        </header>

    </body>
</html>
