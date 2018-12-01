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
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/pizza">Pizzas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/bebida">Bebidas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/funcionario">Funcionários</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div align="center">
            <img src="${pageContext.request.contextPath}/css/pizza-hub-logo.png" alt="some text" width=30% height=30%>
            <div>
                <form action="${pageContext.request.contextPath}/pizza" method="get">
                    <input type="submit" class="btn btn-outline-secondary" value="Gerenciar Pizzas"/>
                </form>
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/bebida" method="get">
                    <input type="submit" class="btn btn-outline-secondary" value="Gerenciar Bebidas"/>
                </form>
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/funcionario" method="get">
                    <input type="submit" class="btn btn-outline-secondary" value="Gerenciar Funcionários"/>
                </form>        
            </div>
        </div>

    </body>
</html>
