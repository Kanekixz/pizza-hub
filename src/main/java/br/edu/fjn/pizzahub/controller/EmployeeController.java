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
import br.edu.fjn.pizzahub.model.Address;
import br.edu.fjn.pizzahub.model.City;
import br.edu.fjn.pizzahub.model.Contact;
import br.edu.fjn.pizzahub.model.Employee;
import br.edu.fjn.pizzahub.model.Person;
import br.edu.fjn.pizzahub.model.State;
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

    @Get("atualizar")
    public void employeeUpdateView() {

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
    public void findByName(Employee employee) throws OrmException {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.findByName(employee.getPerson().getName());
        result.include("employees", employees);
        result.of(this).employeeListView();
    }
    
    @Post("update")
    public void update(Employee employee) throws OrmException {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        /*if (employeeRepository.findById(employee.getId()) != null) {
            Employee e = new Employee();
            Person person = new Person();
            Contact contact = new Contact();
            Address address = new Address();
            
            if (employee.getPerson().getName() != null) {
                person.setName(employee.getPerson().getName());
                e.setPerson(person);
            }
            
            if (employee.getPerson().getCpf() != null) {
                person.setCpf(employee.getPerson().getCpf());
                e.setPerson(person);
            }
            
            if (employee.getDateOfBirth() != null) {
                e.setDateOfBirth(employee.getDateOfBirth());
            }
            
            if (employee.getPerson().getContact().getEmail() != null) {
                contact.setEmail(employee.getPerson().getContact().getEmail());
                person.setContact(contact);
                e.setPerson(person);
            }
            
            if (employee.getPerson().getContact().getPhone() != null) {
                contact.setPhone(employee.getPerson().getContact().getPhone());
                person.setContact(contact);
                e.setPerson(person);
            }
            
            if (employee.getSalary() != 0) {
                e.setSalary(employee.getSalary());
            }
            
            if (employee.getFunction().equals("*")) {
                
            } else {
                e.setFunction(employee.getFunction());
            }
            
            if (employee.getWeeklyWorkload() != 0) {
                e.setWeeklyWorkload(employee.getWeeklyWorkload());
            }
            
            if (employee.getAddress().getState().getUf() != null) {
                State state = new State();
                state.setUf(employee.getAddress().getState().getUf());
                address.setState(state);
                e.setAddress(address);
            }
            
            if (employee.getAddress().getCity().getName() != null) {
                City city = new City();
                city.setName(employee.getAddress().getCity().getName());
                address.setCity(city);
                e.setAddress(address);
            }
            
            if (employee.getAddress().getNeighborhood() != null) {
                address.setNeighborhood(employee.getAddress().getNeighborhood());
                e.setAddress(address);
            }
            
            if (employee.getAddress().getStreet() != null) {
                address.setStreet(employee.getAddress().getStreet());
                e.setAddress(address);
            }
            
            if (employee.getAddress().getNumber() != 0) {
                address.setNumber(employee.getAddress().getNumber());
                e.setAddress(address);
            }
            
            if (employee.getAddress().getComplement()!= null) {
                address.setComplement(employee.getAddress().getComplement());
                e.setAddress(address);
            }
            */
            employeeRepository.update(employee);
            result.redirectTo(this).employeeListView();
        //} else {
          //  result.include("menssage", "Não Existe um funcinário com esse id!");
            //result.redirectTo(this).employeeUpdateView();
        //}

    }

}
