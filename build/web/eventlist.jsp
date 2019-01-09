<%-- 
    Document   : eventlist
    Created on : Jan 1, 2019, 11:07:32 AM
    Author     : nikolaj
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
         <link rel="stylesheet" href="styles.css">
        <title>Events</title>
    </head>
    <body>
        <h1>Pick an event!</h1>
 
   
<%  
    // <option value="1">1</option>
   // <option value="2">2</option>
   // <option value="3">3</option>
    
//int m=obj.cube(5);  
//out.print("cube of 5 is "+m);
EventsBean e = new EventsBean();
List<EventList> list = event.getData();

for(int i = 0; i < list.size(); i++){
        out.println("<td>");
        out.println("<span>");
     out.println("<a href=\"chosenEvent.jsp?eventName="+(list.get(i).getEventName())+"&id="+list.get(i).getId()+"\">"+list.get(i).getEventName()+"</a>");
        out.println("</span>");
        out.println("</td><br>");
}

out.print("</option>");
%>  
 
  Amount of Tickets: <input type="text" name="tickets" value="1" /><br>
  <%
      out.print(" User: <input type=\"text\" name=\"user\" value=\""+request.getAttribute("login")+"\">");
      %>

  
    <% out.println("<b>"+request.getAttribute("login") + "</b>"); %>
    </body>
</html>

    <%-- To display selected value from dropdown list. --%>
  
           
     
</body>