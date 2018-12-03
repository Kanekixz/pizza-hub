<%-- 
    Document   : formView
    Created on : Nov 28, 2018, 6:05:23 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <title>Adcionar Pizza</title>
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
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/pizza/adicionar">Nova Pizza</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/pizza/atualizar">Atualizar Pizza</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/pizza/listar">Lista de Pizzas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div align="center">
            <h1>Adicionar Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/save" method="post">
                <div class="form-group">
                    <div class="col-3">
                        <input type="text" class="form-control" name="pizza.name" value="${pizza.name}" required placeholder="Nome"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-3">
                        <input type="text" class="form-control" name="pizza.flavor" value="${pizza.flavor}" required placeholder="Sabor"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-3">
                        <input type="text" class="form-control" name="pizza.ingredients" value="${pizza.ingredients}" required placeholder="Ingredientes"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-3">
                        <input type="number" class="form-control" name="pizza.price" value="${pizza.price}" required placeholder="Preço"/>
                    </div>
                </div>
                <h5>${menssage}</h5>
                <button type="subimit" class="btn btn-outline-secondary">Adicionar</button>

            </form> 
        </div>


    </body>
</html>
