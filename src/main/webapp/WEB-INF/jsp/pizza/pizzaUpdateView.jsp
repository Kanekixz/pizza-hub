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
        <title>Atualizar Pizza</title>
    </head>
    <body>
        <div>
            <h1>Atualizar Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/update" method="post">
                *Informe o ID da pizza a ser atualizada!
                <br><br>
                ID: <input type="number" name="pizza.id" required/>
                Nome: <input type="text" name="pizza.name"/>
                Sabor: <input type="text" name="pizza.flavor"/>
                Ingredientes: <input type="text" name="pizza.ingredients"/>
                Preço: <input type="number" name="pizza.price"/>
                <br><br>
                Deseja mesmo fazer isso? <input type="checkbox" required/>
                <br><br>
                <button type="subimit">Atualizar</button>
            </form>
        </div>
    </body>
</html>
