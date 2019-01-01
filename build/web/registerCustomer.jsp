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
        <title>Register Customer</title>
    </head>
    <body>
          <form action="RegisterCustomerServlet" method="POST">            
            First name <input type="text" name="firstName" value="" /><br>
            Last name <input type="text" name="lastName" value="" /><br>
            Email <input type="text" name="email" value="" /><br>
            Password <input type="text" name="password" value="" /><br>
            <input type="submit" value="Register" name="submit" />

        </form>
                    <% out.println("<b>"+request.getAttribute("message") + "</b>"); %>

    </body>

</html>
