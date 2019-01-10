<%-- 
    Document   : emptyCart
    Created on : Jan 6, 2019, 9:25:40 PM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="styles.css">

        <title>Empty cart</title>
    </head>
    <body>
                      <div class="w3-top">
        <div class="w3-bar w3-red w3-card w3-left-align w3-large">
            <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
            <a href="logout.jsp" class="w3-bar-item w3-button w3-right w3-padding-large w3-white">Log out</a>
       <%-- <a href="#" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Link 1</a>
            <a href="#" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Link 2</a>
            <a href="#" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Link 3</a>
            <a href="#" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Link 4</a> --%>
        </div>
    </div>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Your cart is empty!</h1>
        </header>
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
                }
            }
        %>
        <a href="eventlist.jsp">Back to eventlist</a>
    <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </footer>
    </body>
</html>
