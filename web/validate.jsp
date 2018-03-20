<%@page import="java.io.PrintWriter"%>
<% 
    String type = request.getParameter("type");
    PrintWriter pw = response.getWriter();
    if(type.equals("insert"))
    {
        request.getRequestDispatcher("insert.jsp").forward(request,response);
    }
    else if(type.equals("select"))
    {
        request.getRequestDispatcher("select.jsp").forward(request,response);
    }
    else if(type.equals("delete"))
    {
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }
    else if(type.equals("update"))
    {
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
    else if(type.equals("selectall"))
    {
        request.getRequestDispatcher("selectall.jsp").forward(request,response);
    }
    else
    {
        pw.print("invalid input!");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validate</title>
    </head>
    <body>
        
    </body>
</html>
