<%-- 
    Document   : chosenEvent
    Created on : Jan 6, 2019, 4:10:27 PM
    Author     : nikolaj, Victor

Description of file: Visar vilket event som kund valt - och ber om uppgifter för köp. Länk till kundvagn
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
        </ul>
        <title>Chosen Event</title>
    </head>
    <body>


        <header>
            <h1>Tickets</h1>
        <form method="post" action="ChosenEventServlet">
            <table align='center'>
                <tr>
                    <td>Event ID:</td>
                    <%
                        String id = request.getParameter("id");
                        String eventName = request.getParameter("eventName");
                        String price = request.getParameter("price");
                        String date = request.getParameter("date");
                        
                        out.println("Date of event: " + date);

                        
                        if (id != null&&eventName != null) {
                            
                            out.println("<td><input name=\"id\" value=\"" + id + "\" ></input></td><br>");
                            out.println("<td><input name=\"eventName\" value=\"" + eventName + "\" ></input></td><br>");
                            out.println("<td><input name=\"price\" value=\"" + price + " \" ></input></td><br>");
                            out.println("<td><input name=\"date\" value=\"" + date + " \" ></input></td><br>");
                            

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
