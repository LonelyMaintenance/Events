<%-- 
    Document   : login
    Created on : Dec 17, 2018, 9:05:29 AM
    Author     : nikolaj, Victor

Description of file: Sida för att registrera ny admin - namn, epost och lösenord anges

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
        <title>Register Admin</title>
    </head>
    <body>

        <header>
            <h1>Register Admin Account</h1>
        <form action="RegisterAdminServlet" method="POST">            
            <label>First name</label><br>
            <input type="text" name="firstName" value="" /><br>
            <label>Last name</label><br>
            <input type="text" name="lastName" value="" /><br>
            <label>Email</label><br>
            <input type="text" name="email" value="" /><br>
            <label>Password</label><br>
            <input type="text" name="password" value="" /><br>
            <input type="submit" value="Register" name="submit" />

        </form>
        </header>

    </body>
</html>
