<%-- 
    Document   : update
    Created on : Mar 16, 2018, 11:35:45 AM
    Author     : A2A Town
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <form action="OperationServlet" method="post">
            Name:<input type="text" name="name"></br>
            Age:<input type="number" name="age"></br>
            Phone:<input type="number" name="phone"></br>
            Email:<input type="text" name="email"></br>
             <input type="hidden" name="op" value="update">
            <input type="submit" value="Update">
        </form>
    </body>
</html>
