<%-- 
    Document   : insert
    Created on : Mar 16, 2018, 11:35:14 AM
    Author     : A2A Town
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        <form action="OperationServlet" method="post">
            Name:<input type="text" name="name"></br>
            Age:<input type="number" name="age"></br>
            Phone:<input type="number" name="phone"></br>
            Email:<input type="text" name="email"></br>
            <input type="hidden" name="op" value="insert">
            <input type="submit" value="Insert">
        </form>
    </body>
</html>
