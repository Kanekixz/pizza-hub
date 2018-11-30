<%-- 
    Document   : pizzaUpdateView
    Created on : Nov 29, 2018, 3:07:44 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <title>Atualizar Pizza</title>
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/pizza/adicionar">Nova Pizza</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/pizza/atualizar">Atualizar Pizza</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/pizza/listar">Lista de Pizzas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div>
            <h1>Atualizar Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/update" method="post">
                *Informe o ID da pizza a ser atualizada!
                <br><br>
                <input type="number" name="pizza.id" value="${pizza.id}" required placeholder="Id"/><br><br>
                <input type="text" name="pizza.name" value="${pizza.name}" placeholder="Nome"/><br><br>
                <input type="text" name="pizza.flavor" value="${pizza.flavor}" placeholder="Sabor"/><br><br>
                <input type="text" name="pizza.ingredients" value="${pizza.ingredients}" placeholder="Ingredientes"/><br><br>
                <input type="number" name="pizza.price" value="${pizza.price}" placeholder="Preço"/>
                <br><br>
                Deseja mesmo fazer isso? <input type="checkbox" required/>
                <br><br>
                <button type="subimit">Atualizar</button>
            </form>
        </div>
    </body>
</html>
