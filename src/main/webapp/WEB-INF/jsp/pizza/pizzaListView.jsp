<%-- 
    Document   : pizzaListView
    Created on : Nov 29, 2018, 4:03:52 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Pizzas</title>
  </head>
  <body>
    <table>
        <thead>
            <tr>
            <th>Nome</th>
            <th>Sabor</th>
            <th>Ingredientes</th>
            <th>Preço(R$)</th>
            <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pizzas}" var="pizza">
                <tr>
                    <td>${pizza.name}</td>
                    <td>${pizza.flavor}</td>
                    <td>${pizza.ingredients}</td>
                    <td>${pizza.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/pizza/atualizar/${pizza.id}">Atualizar</a>
                        <a href="${pageContext.request.contextPath}/pizza/remove/${pizza.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
  </body>
</html>
