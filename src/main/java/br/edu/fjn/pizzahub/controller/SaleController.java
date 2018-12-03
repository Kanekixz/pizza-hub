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
        Employee employee = employeeRepository.findById(sale.getEmployee().getId());
        sale.setEmployee(employee);
        
        DrinkRepository drinkRepository = new DrinkRepository();
        Drink drink0 = drinkRepository.findById(sale.getDrinks().get(0).getId());
        Drink drink1 = drinkRepository.findById(sale.getDrinks().get(1).getId());
        Drink drink2 = drinkRepository.findById(sale.getDrinks().get(2).getId());
        List<Drink> drinks = new ArrayList<Drink>();
        drinks.add(drink0);
        drinks.add(drink1);
        drinks.add(drink2);
        sale.setDrinks(drinks);
        
        PizzaRepository pizzaRepository = new PizzaRepository();
        Pizza pizza0 = pizzaRepository.findById(sale.getPizzas().get(0).getPizza().getId());
        Pizza pizza1 = pizzaRepository.findById(sale.getPizzas().get(1).getPizza().getId());
        Pizza pizza2 = pizzaRepository.findById(sale.getPizzas().get(2).getPizza().getId());
       
        PizzaSize pizzaSize0 = new PizzaSize();
        pizzaSize0.setPizza(pizza0);
        pizzaSize0.setPizzaSize(sale.getPizzas().get(0).getPizzaSize());
        
        PizzaSize pizzaSize1 = new PizzaSize();
        pizzaSize1.setPizza(pizza1);
        pizzaSize1.setPizzaSize(sale.getPizzas().get(1).getPizzaSize());
        
        PizzaSize pizzaSize2 = new PizzaSize();
        pizzaSize2.setPizza(pizza2);
        pizzaSize2.setPizzaSize(sale.getPizzas().get(2).getPizzaSize());
        
        List<PizzaSize> pizzas = new ArrayList<PizzaSize>();
        pizzas.add(pizzaSize0);
        pizzas.add(pizzaSize1);
        pizzas.add(pizzaSize2);
        sale.setPizzas(pizzas);
        
        saleRepository.save(sale);
        result.redirectTo(this).saleListView();

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
        Sale sale = new Sale();
        sale.setId(id);
        SaleRepository saleRepository = new SaleRepository();
        saleRepository.remove(sale.getId());
        result.redirectTo(this).saleListView();
    }
    
    
}
