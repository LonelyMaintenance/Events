<%-- 
    Document   : cartView
    Created on : Jan 6, 2019, 6:10:22 PM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">

        <title>Cart</title>
    </head>
    <body>
        <h1>Your cart!</h1>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
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

    </body>
</html>
