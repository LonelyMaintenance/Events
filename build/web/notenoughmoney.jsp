<%-- 
    Document   : notenoughmoney
    Created on : Jan 9, 2019, 7:28:27 PM
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
        <title>Not Enough Money</title>
    </head>
    <body>

        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Dear customer</h1>
            <h3>You don't have enough money on your account, would you like to empty your cart or return to the menu?</h3>
            <a href="customermenu.jsp">Customer Menu</a><br><br>
            <a href="emptyCart.jsp">Empty cart</a><br><br>
        </header>
            <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </footer>
    </body>
</html>
