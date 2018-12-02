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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <title>Atualizar Pizza</title>
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
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/funcionario/adicionar">Novo Funcionário</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/funcionario/atualizar">Atualizar Funcionário</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light" href="${pageContext.request.contextPath}/funcionario/listar">Lista de Funcionários</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div align="center">
            <h1>Atualizar Funcinário</h1>
            <form action="${pageContext.request.contextPath}/funcionario/update" method="post">
                <div align="center">*Informe o ID do funcionário a ser atualizado!</div>
                <div align="center"><h5>${menssage}</h5></div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="number" class="form-control" name="employee.id" value="${employee.id}" required placeholder="*ID"/>
                    </div>
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.person.name" value="${employee.person.name}"  placeholder="Nome"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.person.cpf" value="${employee.person.cpf}"  placeholder="CPF"/>
                    </div>

                    <div class="col-3">
                        <input type="date" class="form-control" name="employee.dateOfBirth" value="${employee.dateOfBirth}"  placeholder="Data de nascimento"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="email" class="form-control" name="employee.person.contact.email" value="${employee.person.contact.email}"  placeholder="E-mail"/>
                    </div>

                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.person.contact.phone" value="${employee.person.contact.phone}"  placeholder="Telefone"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="number" class="form-control" name="employee.salary" value="${employee.salary}"  placeholder="Salário"/>
                    </div>
                    <div class="col-3">
                        <select class="form-control" name="employee.function" value="${employee.function}"  form="employeeForm">
                            <option value="*" selected="">Cargo</option>
                            <option value="Gerente">Gerente</option>
                            <option value="Atendente">Atendente</option> 
                            <option value="Garcon">Garçon</option> 
                            <option value="Entregador">Entregador</option> 
                        </select>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="number" class="form-control" name="employee.weeklyWorkload" value="${employee.weeklyWorkload}"  placeholder="Carga horária"/>
                    </div>
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.state.uf" value="${employee.address.state.uf}"  placeholder="Estado(UF)"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.city.name" value="${employee.address.city.name}"  placeholder="Cidade"/>
                    </div>

                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.neighborhood" value="${employee.address.neighborhood}"  placeholder="Bairro"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.street" value="${employee.address.street}"  placeholder="Rua"/>
                    </div>
                    <div class="col-3">
                        <input type="number" class="form-control" name="employee.address.number" value="${employee.address.number}"  placeholder="Numero"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.complement" value="${employee.address.complement}" placeholder="Complemento"/>
                    </div>
                </div>
                <div align="center">Deseja mesmo fazer isso? <input type="checkbox" required/></div>
                            <DIV ALIGN="CENTER">
                                <button type="subimit" class="btn btn-outline-secondary">Atualizar</button>
                            </div>
                            </form>
                            </div>
                            </body>
                            </html>
