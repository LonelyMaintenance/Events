<%-- 
    Document   : cartView
    Created on : Jan 6, 2019, 6:10:22 PM
    Author     : nikolaj, Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
        </ul>
        <title>Cart</title>
    </head>
    <body>
        <%-- Logout bar --%>

       <%-- End of bar --%>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Your cart!</h1>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("date")) {
                        out.println("<b>Date of event = " + cookie.getValue() + "<b><br>");

                    }
                    if (cookie.getName().contains("id")) {
                        out.println("<b>Event = " + cookie.getValue() + "<b><br>");

                    }
                    if (cookie.getName().contains("eventName")) {
                        out.println("<b>Name of event = " + cookie.getValue() + "<b><br>");

                    }                    
                    if (cookie.getName().contains("tickets")) {
                        out.println("<b>Number of tickets = " + cookie.getValue() + "<b><br>");

                    }
                    if (cookie.getName().contains("price")) {
                        out.println("<b>Price per ticket = " + cookie.getValue() + "<b><br>");

                    }

                }
            }
        %>
        <form action="EventServlet" method="POST">
            <input type="submit" value="Pay" name="submit" /><br><br>
        </form>
            
        <a href="emptyCart.jsp">Empty cart</a>
        </header>
        <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </footer>
    </body>
</html>
