<%-- 
    Document   : pizzaView
    Created on : Nov 29, 2018, 2:01:07 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <title>Venda</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg">
            <div class="container">
                <div className="navbar-header" class="col-2">
                    <a href='${pageContext.request.contextPath}' class="navbar-brand">
                        <img src="${pageContext.request.contextPath}/css/pizza-hub-logo.png" width=100% height=10%>
                    </a>
                </div>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/venda/adicionar">Nova Venda</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/venda/listar">Lista de Vendas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div align="center">
            <h1>Gerenciar Vendas</h1>
            <div>
                
                <form action="${pageContext.request.contextPath}/venda/adicionar" method="get">
                    <input type="submit" class="btn btn-outline-secondary" value="Adicionar Venda"/>
                </form>
            
                <form action="${pageContext.request.contextPath}/venda/listar" method="get">
                    <input type="submit" class="btn btn-outline-secondary" value="Listar Vendas"/>
                </form>
            </div>
        </div>

    </body>
</html>
