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
        <title>Adcionar Bebida</title>
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
        <div>
            <h1>Adicionar Bebida</h1>
            <form action="${pageContext.request.contextPath}/bebida/save" method="post">
                <input type="text" name="drink.name" value="${drink.name}" required placeholder="Nome"/><br><br>
                <input type="text" name="drink.value" value="${pizza.value}" required placeholder="Valor, Ex: 600ml"/><br><br>
                <input type="number" name="drink.price" value="${drink.price}" required placeholder="Preço"/>
                <br><br>
                <button type="subimit">Adicionar</button>
            </form> 
        </div>


    </body>
</html>
