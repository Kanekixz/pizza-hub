<%-- 
    Document   : formView
    Created on : Nov 28, 2018, 6:05:23 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <title>Adcionar Venda</title>
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
            <h1>Adicionar Venda</h1>
            <form action="${pageContext.request.contextPath}/venda/save" method="post" id="saleForm">
                <div align="center">Os campos com "*" são obrigatórios!</div>
                <div align="center"><h5>${menssage}</h5></div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-2">
                        <input type="text" class="form-control" name="sale.client.person.name" value="${sale.client.person.name}" required placeholder="*Nome do Cliente"/>
                    </div>
                    <div class="col-2">
                        <input type="text" class="form-control" name="sale.client.person.cpf" value="${sale.client.person.cpf}" required placeholder="*CPF do Cliente"/>
                    </div>
                    <div class="col-2">
                        <input type="text" class="form-control" name="sale.client.person.contact.phone" value="${sale.client.person.contact.phone}" placeholder="Telefone do Cliente"/>
                    </div>
                </div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-3">
                        <select class="form-control" name="sale.employee.id" value="${sale.employee.id}" required form="saleForm">
                            <option value="0" selected>*Funcionário</option>
                            <c:forEach items="${employees}" var="employee">
                                <option value="${employee.id}">${employee.person.name}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    <div class="col-3">
                        <select class="form-control" name="sale.paymentMethod" value="${sale.paymentMethod}" required form="saleForm">
                            <option value="*" selected>*Pagamento</option>
                            <option value="Dinheiro">Dinheiro</option>
                            <option value="Cartão de Credito">Cartão de Credito</option>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-2">
                        <input type="text" class="form-control" name="sale.creditCard.number" value="${sale.creditCard.number}" placeholder="Número do Cartão"/>
                    </div>
                    <div class="col-2">
                        <input type="text" class="form-control" name="sale.creditCard.cvv" value="${sale.creditCard.cvv}" placeholder="CVV"/>
                    </div>
                    <div class="col-2">
                        <input type="date" class="form-control" name="sale.creditCard.expirationDate" value="${sale.creditCard.expirationDate}" placeholder="Data de Vencimento"/>
                    </div>
                </div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-2">
                        <select class="form-control" name="sale.drinks[0].id" value="${sale.drinks[0].id}" form="saleForm">
                            <option value="0" selected>Bebida</option>
                            <c:forEach items="${drinks}" var="drink">
                                <option value="${drink.id}">${drink.name}, ${drink.value}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    <div class="col-2">
                        <select class="form-control" name="sale.drinks[1].id" value="${sale.drinks[1].id}" form="saleForm">
                            <option value="0" selected>Bebida</option>
                            <c:forEach items="${drinks}" var="drink">
                                <option value="${drink.id}">${drink.name}, ${drink.value}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    <div class="col-2">
                        <select class="form-control" name="sale.drinks[2].id" value="${sale.drinks[2].id}" form="saleForm">
                            <option value="0" selected>Bebida</option>
                            <c:forEach items="${drinks}" var="drink">
                                <option value="${drink.id}">${drink.name}, ${drink.value}</option>
                            </c:forEach> 
                        </select>
                    </div>

                </div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-3">
                        <select class="form-control" name="sale.pizzas[0].pizza.id" value="${sale.pizzas[0].pizza.id}" form="saleForm">
                            <option value="0" selected>Pizza</option>
                            <c:forEach items="${pizzas}" var="pizza">
                                <option value="${pizza.id}">${pizza.name}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    <div class="col-3">
                        <select class="form-control" name="sale.pizzas[0].pizzaSize" value="${sale.pizzas[0].pizzaSize}" required form="saleForm">
                            <option value="*" selected>Tamanho</option>
                            <option value="Pequena">Pequena</option>
                            <option value="Media">Media</option>
                            <option value="Grande">Grande</option>
                            <option value="Familia">Familia</option>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-3">
                        <select class="form-control" name="sale.pizzas[1].pizza.id" value="${sale.pizzas[1].pizza.id}" form="saleForm">
                            <option value="0" selected>Pizza</option>
                            <c:forEach items="${pizzas}" var="pizza">
                                <option value="${pizza.id}">${pizza.name}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    <div class="col-3">
                        <select class="form-control" name="sale.pizzas[1].pizzaSize" value="${sale.pizzas[1].pizzaSize}" required form="saleForm">
                            <option value="*" selected>Tamanho</option>
                            <option value="Pequena">Pequena</option>
                            <option value="Media">Media</option>
                            <option value="Grande">Grande</option>
                            <option value="Familia">Familia</option>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-3">
                        <select class="form-control" name="sale.pizzas[2].pizza.id" value="${sale.pizzas[2].pizza.id}" form="saleForm">
                            <option value="0" selected>Pizza</option>
                            <c:forEach items="${pizzas}" var="pizza">
                                <option value="${pizza.id}">${pizza.name}</option>
                            </c:forEach> 
                        </select>
                    </div>
                    <div class="col-3">
                        <select class="form-control" name="sale.pizzas[2].pizzaSize" value="${sale.pizzas[2].pizzaSize}" required form="saleForm">
                            <option value="*" selected>Tamanho</option>
                            <option value="Pequena">Pequena</option>
                            <option value="Media">Media</option>
                            <option value="Grande">Grande</option>
                            <option value="Familia">Familia</option>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-md-center" id="rowSale">
                    <div class="col-2">
                        <input type="number" class="form-control" name="sale.totalPrice" value="${sale.totalPrice}" placeholder="Total(R$)"/>
                    </div>
                </div>

                <button type="subimit" class="btn btn-outline-secondary">Adicionar</button>

            </form> 
        </div>


    </body>
</html>
