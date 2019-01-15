<%-- 
    Document   : adminmenu
    Created on : Jan 10, 2019, 2:36:42 PM
    Author     : nikolaj, Victor

    Description of file: Shows href-links to pages the admin has access to
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
        <title>Admin menu</title>

    </head>
    <header>
    <body>

            <h1>Admin menu</h1>
        <a href="userlist.jsp">View list of users</a><br>
    
        <a href="newEvent.jsp">Add new event</a><br>

        <a href="registerAdmin.jsp">Register new admin</a><br>
        
        <a href="inactivateevent.jsp">Cancel event</a><br>

        <a href="inactiveateuser.jsp">Unregister user</a><br>
        </header>
        
        

    </body>
</html>
