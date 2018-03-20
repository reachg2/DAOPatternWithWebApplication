<%-- 
    Document   : delete
    Created on : Mar 16, 2018, 11:35:38 AM
    Author     : A2A Town
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>
    </head>
    <body>
        <form action="OperationServlet" method="post">
            Name:<input type="text" name="name"></br>
             <input type="hidden" name="op" value="delete">
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
