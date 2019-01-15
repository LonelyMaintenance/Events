<%-- 
    Document   : customerstickets
    Created on : Jan 10, 2019, 4:18:09 PM
    Author     : nikolaj, Victor

Description of file: Visar användares köphistorik

--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminEventBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
            <ul><a href="customermenu.jsp">Menu</a></ul>
        </ul>
        <title>Ticket history</title>
    </head>
    <body>

        <header>
            <h1>Every ticket you bought here!</h1>
    
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

    </body>
</html>
