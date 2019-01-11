<%-- 
    Document   : chosenEvent
    Created on : Jan 6, 2019, 4:10:27 PM
    Author     : nikolaj, Victor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
            .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
            .fa-anchor,.fa-coffee {font-size:200px}
        </style>
        <title>Chosen Event</title>
    </head>
    <body>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Tickets</h1>
        <form method="post" action="ChosenEventServlet">
            <table align='center'>
                <tr>
                    <td>Chosen Event</td>
                    <%
                        String id = request.getParameter("id");
                        String eventName = request.getParameter("eventName");
                        String price = request.getParameter("price");

                        
                        if (id != null&&eventName != null) {
                            out.println("<h1>Chosen number at " + id + "</h1");
                            out.println("<td><input name=\"id\" value=\"" + id + "\" ></input></td>");
                            out.println("<td><input name=\"eventName\" value=\"" + eventName + "\" ></input></td>");
                            out.println("<td><input name=\"price\" value=\"" + price + "\" ></input></td>");
                            

                        }
                        /* TODO output your page here. You may use following sample code. */


                    %>

                    </tr>
                    <tr>
                    <td>Number of tickets:</td>
                    <td><input name="tickets" value="1"/></td>
                </tr>
                <tr>
                <td align='center'><input type="submit" value="Add" /></td>
                </tr>

            </table>
        </form>
        <a href="cartView.jsp">View cart</a>
        </header>
    </body>
</html>
