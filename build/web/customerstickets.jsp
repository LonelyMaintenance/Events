<%-- 
    Document   : customerstickets
    Created on : Jan 10, 2019, 4:18:09 PM
    Author     : nikolaj, Victor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminEventBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <title>Ticket history</title>
    </head>
    <body>
                <div class="w3-top">
        <div class="w3-bar w3-red w3-card w3-left-align w3-large">
            <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
            <a href="logout.jsp" class="w3-bar-item w3-button w3-right w3-padding-large w3-white">Log out</a>
                    <a href="customermenu.jsp" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Customer Menu</a>

       <%-- 
            <a href="#" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Link 2</a>
            <a href="#" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Link 3</a>
            <a href="#" class="w3-bar-item w3-button w3-right w3-hide-small w3-padding-large w3-hover-white">Link 4</a> --%>
        </div>
    </div>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Every ticket you bought here!</h1>
    
        <%
            String email = null;
              Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("user")) {
                        email = cookie.getValue();
                                    if(email!=null){
            AdminEventBean aeb = new AdminEventBean();
            aeb.init();
            ArrayList<String> tickets = aeb.getPurchaseHistory(email);
            for(int i = 0; i < tickets.size(); i++){
                out.println(tickets.get(i));
                out.println("<br>");
            }
            aeb.closeConnection();
            }

                    }


                }
            }
                       

            %>
            </header>
                <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </footer>
    </body>
</html>
