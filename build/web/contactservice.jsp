<%-- 
    Document   : login
    Created on : Dec 17, 2018, 9:05:29 AM
    Author     : nikolaj, Victor
Description of file: Sida för att skicka frågor till kundtjänst
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="styles.css">
                <ul>
            <ul><a href="welcomePage.jsp">Main</a></ul>
        </ul>
        <title>Send question to service</title>
    </head>
    <body>
        <header>
            <h1>Question</h1>
        <form action="QuestionServlet" method="POST">
            <label>Gmail username</label><br>
            <input type="text" name="username" value="" /><br>
            <label>Gmail password</label><br>
            <input type="text" name="pass" value="" /><br>
            <label>Your Question</label><br>
            <input type="text" name="question" value="" /><br>
            <label>Contact me on this email:</label><br>
            <input type="text" name="email" value="" /><br>
            <input type="submit" value="Send" name="submit" />
        </form>
        </header>

    </body>
</html>
