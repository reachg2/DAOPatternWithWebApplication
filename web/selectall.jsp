<%-- 
    Document   : selectall
    Created on : Mar 16, 2018, 11:35:58 AM
    Author     : A2A Town
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select All</title>
    </head>
    <body>
        <form action="OperationServlet" method="post">
            <input type="hidden" name="op" value="selectall">
            <input type="submit" value="Select All">
        </form>
    </body>
</html>
