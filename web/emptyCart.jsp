<%-- 
    Document   : emptyCart
    Created on : Jan 6, 2019, 9:25:40 PM
    Author     : nikolaj, Victor

Description of file: Tömmer köpvagn genom att tömma cookie arrays

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
        <title>Empty cart</title>
    </head>
    <body>

        <header>
            <h1>Your cart is empty!</h1>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("id")) {
                        Cookie eventCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        eventCookie.setMaxAge(0);
                        response.addCookie(eventCookie);

                    }
                    if (cookie.getName().contains("tickets")) {
                        
                        Cookie ticketCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        ticketCookie.setMaxAge(0);
                        response.addCookie(ticketCookie);

                    }
                        if (cookie.getName().contains("eventName")) {

                        Cookie eventNameCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        eventNameCookie.setMaxAge(0);
                        response.addCookie(eventNameCookie);

                    }
                    if (cookie.getName().contains("price")) {

                        Cookie priceCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        priceCookie.setMaxAge(0);
                        response.addCookie(priceCookie);

                    }
                    if (cookie.getName().contains("date")) {

                        Cookie dateCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        dateCookie.setMaxAge(0);
                        response.addCookie(dateCookie);

                    }
                }
            }
        %>
        <a href="eventlist.jsp">Back to eventlist</a>
        </header>
        

    </body>
</html>
