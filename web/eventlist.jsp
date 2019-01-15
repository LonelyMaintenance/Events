<%-- 
    Document   : eventlist
    Created on : Jan 1, 2019, 11:07:32 AM
    Author     : nikolaj, Victor

Description of file: Sida som hämtar alla events från db (via bean), och printar ut dom för användaren.
Inställda event presenteras som cancelled

--%>

<%@page import="web.EventList"%>
<%@page import="bean.EventsBean"%>
<%@page import="web.Event"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="event" class="bean.EventsBean"/>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
            <ul><a href="cartView.jsp">View cart</a></ul>
        </ul>
        <title>Events</title>
    </head>
    <body>

        <header>
            <h1>Pick an event!</h1>

        <%

            EventsBean e = new EventsBean();
            List<EventList> list = event.getData();

            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).isIsCancelled()==true){
                out.println("<td>");
                out.println("<span>");
                out.println("<a href=\"customerinfoeventcancelled.jsp\">" + String.format("[CANCELLED] "+ list.get(i).getDate() + ": "+list.get(i).getEventName()) + "</a>");
                out.println("</span>");
                out.println("</td><br><br>");                    
                }else{
                out.println("<td>");
                out.println("<span>");
                out.println("<a href=\"chosenEvent.jsp?eventName=" + (list.get(i).getEventName()) + "&id=" + list.get(i).getId() + "&price="+(list.get(i).getPrice())+"&date="+list.get(i).getDate()+"\">" + String.format(list.get(i).getDate() +" "+ list.get(i).getEventName()) + "</a>");
                out.println("</span>");
                out.println("</td><br><br>");      
                }

            }

            out.print("</option>");
        %>  



</header>

    </body>
</html>




</body>