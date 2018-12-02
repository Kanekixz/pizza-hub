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
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/bebida/adicionar">Nova Bebida</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/bebida/atualizar">Atualizar Bebida</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/bebida/listar">Lista de Bebidas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div align="center">
            <h1>Adicionar Bebida</h1>
            <form action="${pageContext.request.contextPath}/bebida/save" method="post">
                <div class="form-group">
                    <div class="col-3">
                        <input type="text" class="form-control" name="drink.name" value="${drink.name}" required placeholder="Nome"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-3">
                        <input type="text" class="form-control" name="drink.value" value="${drink.value}" required placeholder="Valor, Ex: 600ml"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-3">
                        <input type="number" class="form-control" name="drink.price" value="${drink.price}" required placeholder="Preço"/>
                    </div>
                </div>
                <button type="subimit" class="btn btn-outline-secondary">Adicionar</button>
            </form> 
        </div>

    </body>
</html>
