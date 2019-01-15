<%-- 
    Document   : userlist
    Created on : Jan 13, 2019, 2:55:43 PM
    Author     : nikolaj

Description of file: Sida som printar ut alla användare från db (via bean)
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminUserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
        </ul>
        <title>List of users</title>
    </head>
    <body>

   
        <header>
            <h1>List of users</h1>
    <%
        AdminUserBean aub = new AdminUserBean();
        aub.init();
        ArrayList<String> list = aub.getUserListStatement();
    
            for(int i = 0; i < list.size(); i++){
                out.println(list.get(i)+"<br><br>");
            }
            %>        </header>

    </body>
</html>