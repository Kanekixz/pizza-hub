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
        <title>Adcionar Funcionário</title>
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
            <h1>Adicionar Funcionário</h1>
            <form action="${pageContext.request.contextPath}/funcionario/save" method="post" id="employeeForm">
                <div align="center">Os campos com "*" são obrigatórios!</div>
                <div align="center"><h5>${menssage}</h5></div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.person.name" value="${employee.person.name}" required placeholder="*Nome"/>
                    </div>
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.person.cpf" value="${employee.person.cpf}" required placeholder="*CPF"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="date" class="form-control" name="employee.dateOfBirth" value="${employee.dateOfBirth}" required placeholder="*Data de nascimento"/>
                    </div>

                    <div class="col-3">
                        <input type="email" class="form-control" name="employee.person.contact.email" value="${employee.person.contact.email}" required placeholder="*E-mail"/>
                    </div>
                    </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.person.contact.phone" value="${employee.person.contact.phone}" required placeholder="*Telefone"/>
                    </div>

                    <div class="col-3">
                        <input type="number" class="form-control" name="employee.salary" value="${employee.salary}" required placeholder="*Salário"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <select class="form-control" name="employee.function" value="${employee.function}" required form="employeeForm">
                            <option value="*" selected="">*Cargo</option>
                            <option value="Gerente">Gerente</option>
                            <option value="Atendente">Atendente</option> 
                            <option value="Garcon">Garçon</option> 
                            <option value="Entregador">Entregador</option> 
                        </select>
                    </div>

                    <div class="col-3">
                        <input type="number" class="form-control" name="employee.weeklyWorkload" value="${employee.weeklyWorkload}" required placeholder="*Carga horária"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.state.uf" value="${employee.address.state.uf}" required placeholder="*Estado(UF)"/>
                    </div>

                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.city.name" value="${employee.address.city.name}" required placeholder="*Cidade"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.neighborhood" value="${employee.address.neighborhood}" required placeholder="*Bairro"/>
                    </div>

                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.street" value="${employee.address.street}" required placeholder="*Rua"/>
                    </div>
                </div>
                <div class="row" id="rowEmployee">
                    <div class="col-3">
                        <input type="number" class="form-control" name="employee.address.number" value="${employee.address.number}" required placeholder="*Numero"/>
                    </div>

                    <div class="col-3">
                        <input type="text" class="form-control" name="employee.address.complement" value="${employee.address.complement}" placeholder="Complemento"/>
                    </div>
                </div>
                <button type="subimit" class="btn btn-outline-secondary">Adicionar</button>

            </form> 
        </div>


    </body>
</html>
