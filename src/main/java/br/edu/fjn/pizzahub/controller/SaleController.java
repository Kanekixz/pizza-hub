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
import br.edu.fjn.pizzahub.model.Drink;
import br.edu.fjn.pizzahub.model.Employee;
import br.edu.fjn.pizzahub.model.Pizza;
import br.edu.fjn.pizzahub.model.PizzaSize;
import br.edu.fjn.pizzahub.model.Sale;
import br.edu.fjn.pizzahub.persistence.DrinkRepository;
import br.edu.fjn.pizzahub.persistence.EmployeeRepository;
import br.edu.fjn.pizzahub.persistence.PersonRepository;
import br.edu.fjn.pizzahub.persistence.PizzaRepository;
import br.edu.fjn.pizzahub.persistence.SaleRepository;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Hugo
 */
@Controller
@Path("venda")
public class SaleController {

    @Inject
    private Result result;

    @Get("")
    public void saleView() {

    }

    @Get("listar")
    public void saleListView() {
        SaleRepository saleRepository = new SaleRepository();
        List<Sale> sales = saleRepository.listAll();
        result.include("sales", sales);
    }

    @Get("adicionar")
    public void saleSaveView() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.listAll();

        DrinkRepository drinkRepository = new DrinkRepository();
        List<Drink> drinks = drinkRepository.listAll();

        PizzaRepository pizzaRepository = new PizzaRepository();
        List<Pizza> pizzas = pizzaRepository.listAll();

        result.include("employees", employees);
        result.include("drinks", drinks);
        result.include("pizzas", pizzas);
    }

    @Post("save")
    public void save(Sale sale) throws OrmException {
        SaleRepository saleRepository = new SaleRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();

        if (sale.getPaymentMethod().equals("*")) {
            result.include("menssage", "Selecione um pagamento válido!");
            result.redirectTo(this).saleSaveView();
        } else {
            if (employeeRepository.findById(sale.getEmployee().getId()) == null) {
                result.include("menssage", "Selecione um funcinário válido!");
                result.redirectTo(this).saleSaveView();
            } else {
                Employee employee = employeeRepository.findById(sale.getEmployee().getId());
                sale.setEmployee(employee);

                PersonRepository personRepository = new PersonRepository();

                if (personRepository.findByCpf(sale.getClient().getPerson().getCpf()) != null) {
                    result.include("menssage", "Já existe um cliente com esse cpf!");
                    result.redirectTo(this).saleSaveView();
                } else {
                    DrinkRepository drinkRepository = new DrinkRepository();
                    List<Drink> drinks = new ArrayList<Drink>();
                    for (int i = 0; i < sale.getDrinks().size(); i++) {

                        if (drinkRepository.findById(sale.getDrinks().get(i).getId()) != null) {
                            Drink drink = drinkRepository.findById(sale.getDrinks().get(i).getId());
                            drinks.add(drink);
                        }
                    }
                    sale.setDrinks(drinks);

                    PizzaRepository pizzaRepository = new PizzaRepository();
                    List<PizzaSize> pizzas = new ArrayList<PizzaSize>();
                    for (int i = 0; i < sale.getPizzas().size(); i++) {
                        if (pizzaRepository.findById(sale.getPizzas().get(i).getPizza().getId()) != null) {
                            Pizza pizza = pizzaRepository.findById(sale.getPizzas().get(i).getPizza().getId());
                            PizzaSize pizzaSize = new PizzaSize();
                            pizzaSize.setPizza(pizza);
                            pizzaSize.setPizzaSize(sale.getPizzas().get(i).getPizzaSize());

                            pizzas.add(pizzaSize);
                        }
                    }
                    sale.setPizzas(pizzas);

                    saleRepository.save(sale);
                    result.redirectTo(this).saleListView();
                }

            }
        }

    }

    @Post("buscar")
    public void findByName(Sale sale) throws OrmException {
        SaleRepository saleRepository = new SaleRepository();
        List<Sale> sales = saleRepository.findByEmployeeName(sale.getEmployee().getPerson().getName());
        result.include("sales", sales);
        result.of(this).saleListView();
    }

    @Get("remove/{id}")
    public void remove(Integer id) throws OrmException {
        SaleRepository saleRepository = new SaleRepository();
        saleRepository.remove(id);
        result.redirectTo(this).saleListView();
    }

}
