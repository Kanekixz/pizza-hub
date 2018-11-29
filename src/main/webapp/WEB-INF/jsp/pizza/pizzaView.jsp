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
        <title>Pizza</title>
    </head>
    <body>
        <div>
            <h1>Adicionar Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/adicionar" method="get">
                <input type="submit" value="Adicionar pizza"/>
            </form>
        </div>
                
        <div>
            <h1>Remover Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/remover" method="get">
                <input type="submit" value="Remover pizza"/>
            </form>
        </div>
                
        <div>
            <h1>Atualizar Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/atualizar" method="get">
                <input type="submit" value="Atualizar pizza"/>
            </form>
        </div>
                
        <div>
            <h1>Listar Pizzas</h1>
            <form action="${pageContext.request.contextPath}/pizza/listar" method="get">
                <input type="submit" value="Listar pizzas"/>
            </form>
        </div>
        
    </body>
</html>
