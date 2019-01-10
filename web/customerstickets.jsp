<%-- 
    Document   : customerstickets
    Created on : Jan 10, 2019, 4:18:09 PM
    Author     : nikolaj
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminEventBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket history</title>
    </head>
    <body>
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
            
    </body>
</html>
