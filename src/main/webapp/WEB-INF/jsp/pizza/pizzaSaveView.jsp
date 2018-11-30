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
        <title>Adcionar Pizza</title>
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
            <h1>Adicionar Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/save" method="post">
                Nome: <input type="text" name="pizza.name" value="${pizza.name}" required/>
                Sabor: <input type="text" name="pizza.flavor" value="${pizza.flavor}" required/>
                Ingredientes: <input type="text" name="pizza.ingredients" value="${pizza.ingredients}" required/>
                Preço(R$): <input type="number" name="pizza.price" value="${pizza.price}" required/>
                <br><br>
                <button type="subimit">Adicionar</button>
            </form> 
        </div>


    </body>
</html>
