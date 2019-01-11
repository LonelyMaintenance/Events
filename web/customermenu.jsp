<%-- 
    Document   : customermenu
    Created on : Jan 10, 2019, 4:38:32 PM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Customer Menu</title>
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
            <h1 class="w3-margin w3-jumbo">Customer Menu</h1>
        </header>
    
        <a href="customerstickets.jsp">The tickets you've bought</a><br>
        <a href="eventlist.jsp">Buy a new ticket</a><br>
        <a href="logout.jsp">Log out page</a><br>        
        <a href="index.html">Main page</a><br
                <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </footer>
    </body>
</html>