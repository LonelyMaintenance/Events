<%-- 
    Document   : login
    Created on : Dec 17, 2018, 9:05:29 AM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="styles.css">
        <title>Send question to service</title>
    </head>
    <body>
          <form action="QuestionServlet" method="POST">
            Gmail username <input type="text" name="username" value="" /><br>
            Gmail password <input type="text" name="pass" value="" /><br>
            Your Question <input type="text" name="question" value="" /><br>
            Contact me on this email: <input type="text" name="email" value="" /><br>
            <input type="submit" value="Send" name="submit" />
        </form>
                    <% out.println("<b>"+request.getAttribute("message") + "</b>"); %>

    </body>

</html>
