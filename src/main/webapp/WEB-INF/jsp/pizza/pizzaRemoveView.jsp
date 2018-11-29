<%-- 
    Document   : pizzaRemoveView
    Created on : Nov 29, 2018, 2:28:38 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover pizza</title>
    </head>
    <body>
        <div>
            <h1>Remover Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/remove" method="post">
                ID <input type="number" name="pizza.id" value="${pizza.id}" required/>
                <br><br>
                Deseja mesmo fazer isso? <input type="checkbox" required/>
                <br><br>
                <button type="subimit">Remover</button>
            </form>
        </div>
    </body>
</html>
