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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <title>Pizza Hub</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg">
            <div class="container">
                <div className="navbar-header" class="col-2">
                    <a href='${pageContext.request.contextPath}' class="navbar-brand">
                        <img src="${pageContext.request.contextPath}/css/pizza-hub-logo.png" width=100% height=100%>
                    </a>
                </div>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/pizza">Gerenciador de Pizzas</a>
                    </li>
                    
                </ul>
            </div>
        </nav>
        <img src="${pageContext.request.contextPath}/css/pizza-hub-logo.png" alt="some text" width=30% height=30%>
        <div>
            <h2>Gerenciador de pizzas</h2>
            <form action="${pageContext.request.contextPath}/pizza" method="get">
                <input type="submit" value="Gerenciar"/>
            </form>
        </div>
    </body>
</html>
