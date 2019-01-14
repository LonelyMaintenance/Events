<%-- 
    Document   : adminmenu
    Created on : Jan 10, 2019, 2:36:42 PM
    Author     : nikolaj, Victor
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
                        <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
        </ul>
        <title>Admin menu</title>

    </head>
    <body>

        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Admin menu</h1>
        <a href="userlist.jsp">View list of users</a><br>
    
        <a href="newEvent.jsp">Add new event</a><br>

        <a href="registerAdmin.jsp">Register new admin</a><br>
        
        <a href="inactivateevent.jsp">Cancel event</a><br>

        <a href="inactiveateuser.jsp">Unregister user</a><br>
        </header>
        
        
            <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </footer>
    </body>
</html>
