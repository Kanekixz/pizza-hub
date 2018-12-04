<%-- 
    Document   : pizzaListView
    Created on : Nov 29, 2018, 4:03:52 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Vendas</title>
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
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/venda/adicionar">Nova Venda</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/venda/listar">Lista de Vendas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div align="center">
            <table class="table table-bordered table-dark table-hover container">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Funcionário</th>
                        <th>Cliente</th>
                        <th>CPF Cliente</th>
                        <th>Pagamento</th>
                        <th>Cartão(se usado)</th>
                        <th>Bebidas</th>
                        <th>Pizzas</th>
                        <th>Total(R$)</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                <div>
                    <form action="${pageContext.request.contextPath}/venda/buscar" method="post">
                        <div class="form-group">
                            <div class="row justify-content-md-center">
                                <div class="col-3">
                                    <input type="text" class="form-control" required placeholder="Buscar funcinário" name="sale.employee.person.name" value="${sale.employee.person.name}"/>
                                </div>
                                <div class="col-0">
                                    <input id="btnList" type="submit" class="btn btn-outline-secondary" value="Buscar"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <c:forEach items="${sales}" var="sale">
                    <tr>
                        <td>${sale.id}</td>
                        <td>${sale.employee.person.name}</td>
                        <td>${sale.client.person.name}</td>
                        <td>${sale.client.person.cpf}</td>
                        <td>${sale.paymentMethod}</td>
                        <td>${sale.creditCard.number}</td>
                        <td>
                            <c:forEach items="${sale.drinks}" var="drink">
                                ${drink.name}, ${drink.value}<br>
                            </c:forEach>
                            
                        </td>
                        <td>
                            <c:forEach items="${sale.pizzas}" var="pizzaSize">
                                ${pizzaSize.pizza.name}, ${pizzaSize.pizzaSize}<br>
                            </c:forEach>
                        </td>
                        <td>${sale.totalPrice}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/venda/remove/${sale.id}">Remover</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </DIV>
    </body>
</html>
