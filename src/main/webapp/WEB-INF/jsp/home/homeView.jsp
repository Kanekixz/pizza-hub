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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <title>Pizza Hub</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <div className="navbar-header">
                    <a href='${pageContext.request.contextPath}' class="navbar-brand">
                        Pizza Hub
                    </a>
                </div>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/pizza">Gerenciador de Pizzas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <h1>Pizza Hub</h1>
        <div>
            <h2>Gerenciador de pizzas</h2>
            <form action="${pageContext.request.contextPath}/pizza" method="get">
                <input type="submit" value="Gerenciar"/>
            </form>
        </div>
    </body>
</html>
