<%-- 
    Document   : eventlist
    Created on : Jan 1, 2019, 11:07:32 AM
    Author     : nikolaj, Victor
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
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                <link rel="stylesheet" type="text/css" href="styles.css">

                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
            <ul><a href="cartView.jsp">View cart</a></ul>
        </ul>
        <title>Events</title>
    </head>
    <body>

        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Pick an event!</h1>

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
    <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </footer>
    </body>
</html>




</body>