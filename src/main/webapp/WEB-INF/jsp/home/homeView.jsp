<%-- 
    Document   : homeView
    Created on : Nov 29, 2018, 1:50:07 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Hub</title>
    </head>
    <body>
        <h1>Pizza Hub</h1>
        <div>
            <h2>Gerenciador de pizzas</h2>
            <form action="${pageContext.request.contextPath}/pizza" method="get">
                <input type="submit" value="Gerenciar"/>
            </form>
        </div>
    </body>
</html>
