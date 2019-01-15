<%-- 
    Document   : notenoughmoney
    Created on : Jan 9, 2019, 7:28:27 PM
    Author     : nikolaj, Victor

Description of file: Sida för att visa meddelande om det har visat sig att användare inte har tillräckligt
med pengar på sitt presentkort (webbtjänst MyGift) för att betala biljetterna i sin kundkorg

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
        <title>Not Enough Money</title>
    </head>
    <body>

        <header>
            <h1>Dear customer</h1>
            <h3>You don't have enough money on your account, would you like to empty your cart or return to the menu?</h3>
            <a href="customermenu.jsp">Customer Menu</a><br><br>
            <a href="emptyCart.jsp">Empty cart</a><br><br>
        </header>

    </body>
</html>
