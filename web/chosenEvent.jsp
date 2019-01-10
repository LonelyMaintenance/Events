<%-- 
    Document   : chosenEvent
    Created on : Jan 6, 2019, 4:10:27 PM
    Author     : nikolaj
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">

        <title>Chosen Event</title>
    </head>
    <body>
        <form method="post" action="ChosenEventServlet">
            <table>
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


                    <td>Number of tickets:</td>
                    <td><input name="tickets" value="1"/></td>
                </tr>

                <td><input type="submit" value="Add" /></td>


            </table>
        </form>


        <a href="cartView.jsp">View cart</a>

    </body>
</html>
