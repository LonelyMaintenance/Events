<%-- 
    Document   : welcomePage
    Created on : 2019-jan-10, 07:40:59
    Author     : Victor

Description of file: Sida för att välkomna till sidan och länka till kontaktsida, login 
och registrering för nya kunder.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Events.com</title>
                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="login.jsp">Log in</a></ul>
            <ul><a href="registerCustomer.jsp">Register</a></ul>

                </ul>
    </head>
    <body>

        <header>
            <h1>Welcome to Events.com!</h1>
        </header>
        <br><br><br><br><br><br>
                <a href="contactservice.jsp">Contacts us</a>

    </body>
</html>
