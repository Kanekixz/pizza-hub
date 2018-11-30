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
        <title>Atualizar Pizza</title>
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
                ID: <input type="number" name="pizza.id" value="${pizza.id}" required/>
                Nome: <input type="text" name="pizza.name" value="${pizza.name}"/>
                Sabor: <input type="text" name="pizza.flavor" value="${pizza.flavor}"/>
                Ingredientes: <input type="text" name="pizza.ingredients" value="${pizza.ingredients}"/>
                Preço: <input type="number" name="pizza.price" value="${pizza.price}"/>
                <br><br>
                Deseja mesmo fazer isso? <input type="checkbox" required/>
                <br><br>
                <button type="subimit">Atualizar</button>
            </form>
        </div>
    </body>
</html>
