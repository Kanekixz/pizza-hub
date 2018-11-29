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
        <title>Adcionar Pizza</title>
    </head>
    <body>
        <div>
           <h1>Adicionar Pizza</h1>
            <form action="${pageContext.request.contextPath}/pizza/save" method="post">
                Nome: <input type="text" name="pizza.name" required/>
                Sabor: <input type="text" name="pizza.flavor" required/>
                Ingredientes: <input type="text" name="pizza.ingredients" required/>
                Preço: <input type="number" name="pizza.price" required/>
                <br><br>
                <button type="subimit">Adicionar</button>
            </form> 
        </div>
        
        
    </body>
</html>
