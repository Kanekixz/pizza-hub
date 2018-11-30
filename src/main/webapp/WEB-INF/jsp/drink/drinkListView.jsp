<%-- 
    Document   : pizzaListView
    Created on : Nov 29, 2018, 4:03:52 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pizzas</title>
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/bebida/adicionar">Nova Bebida</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/bebida/atualizar">Atualizar Bebida</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/bebida/listar">Lista de Bebidas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Valor</th>
                    <th>Preço(R$)</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <div>
                <form action="${pageContext.request.contextPath}/bebida/buscar" method="post">
                    <input type="text" required placeholder="Buscar nome" name="drink.name" value="${dink.name}"/>
                    <input type="submit" value="Buscar"/>
                </form>
            </div>
            <c:forEach items="${drinks}" var="drink">
                <tr>
                    <td>${drink.id}</td>
                    <td>${drink.name}</td>
                    <td>${drink.value}</td>
                    <td>${drink.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/bebida/remove/${drink.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
</body>
</html>
