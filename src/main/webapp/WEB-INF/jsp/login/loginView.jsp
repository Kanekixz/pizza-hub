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
        <title>Login</title>
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
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/register">Cadastre-se</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div align="center">
            <h1>Login</h1>
            <form action="${pageContext.request.contextPath}/logar" method="post">
                <div class="form-group">
                    <div class="col-2">
                        <input type="text" class="form-control" name="login.username" value="${login.username}" required placeholder="Usuario"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-2">
                        <input type="password" class="form-control" name="login.password" value="${login.password}" required placeholder="Senha"/>
                    </div>
                </div>     
                <h5>${menssage}</h5>
                <button type="subimit" class="btn btn-outline-secondary">Entrar</button>

            </form> 
        </div>


    </body>
</html>
