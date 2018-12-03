/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fjn.pizzahub.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.fjn.pizzahub.model.Employee;
import br.edu.fjn.pizzahub.persistence.EmployeeRepository;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author aluno
 */
@Controller
@Path("funcionario")
public class EmployeeController {

    @Inject
    private Result result;

    @Get("")
    public void employeeView() {

    }

    @Get("adicionar")
    public void employeeSaveView() {

    }

    @Get("listar")
    public void employeeListView() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.listAll();
        result.include("employees", employees);
    }

    @Post("save")
    public void save(Employee employee) throws OrmException {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        if (employee.getFunction().equals("*")) {
            result.include("menssage", "Selecione um cargo válido!");
            result.redirectTo(this).employeeSaveView();
        } else {
            if (employeeRepository.findByCpf(employee.getPerson().getCpf()) == null) {

                if (employeeRepository.findByEmail(employee.getPerson().getContact().getEmail()) == null) {

                    if (employeeRepository.findByPhone(employee.getPerson().getContact().getPhone()) == null) {
                        employeeRepository.save(employee);
                        result.redirectTo(this).employeeListView();
                    } else {
                        result.include("menssage", "Já existe um funcinário com esse telefone!");
                        result.redirectTo(this).employeeSaveView();
                    }
       
                } else {
                    result.include("menssage", "Já existe um funcinário com esse email!");
                    result.redirectTo(this).employeeSaveView();
                }

            } else {
                result.include("menssage", "Já existe um funcinário com esse cpf!");
                result.redirectTo(this).employeeSaveView();
            }
        }

    }
    
    @Get("remove/{id}")
    public void remove(Integer id) throws OrmException {
        Employee employee = new Employee();
        employee.setId(id);
        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.remove(employee.getId());
        result.redirectTo(this).employeeListView();
    }
    
    @Post("buscar")
    public void find(Employee employee) throws OrmException {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.findByNameAndFunction(employee.getPerson().getName(), employee.getFunction());
        result.include("employees", employees);
        result.of(this).employeeListView();
    }
    
    

}
