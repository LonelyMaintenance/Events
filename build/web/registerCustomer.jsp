<%-- 
    Document   : login
    Created on : Dec 17, 2018, 9:05:29 AM
    Author     : nikolaj, Victor

Description of file: Sida för att registrera ny användare - namn, epost och lösenord anges

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
        <title>Register Customer</title>
    </head>
    <body>

        <header>
            <h1>Register Customer Account</h1>
        <form action="RegisterCustomerServlet" method="POST">            
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
            <% //out.println("<b>" + request.getAttribute("message") + "</b>");%>
        </header> 

    </body>
</html>
