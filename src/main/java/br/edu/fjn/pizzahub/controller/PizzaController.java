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
import br.edu.fjn.pizzahub.persistence.PizzaRepository;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.model.Pizza;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Hugo
 */
@Controller
@Path("pizza")
public class PizzaController {

    @Inject
    private Result result;

    @Get("")
    public void pizzaView() {

    }

    @Get("adicionar")
    public void pizzaSaveView() {

    }

    @Get("atualizar")
    public void pizzaUpdateView() {

    }

    @Get("listar")
    public void pizzaListView() {
        PizzaRepository pizzaRepository = new PizzaRepository();
        List<Pizza> pizzas = pizzaRepository.listAll();
        result.include("pizzas", pizzas);
    }

    @Post("save")
    public void save(Pizza pizza) throws OrmException {
        PizzaRepository pizzaRepository = new PizzaRepository();
        pizzaRepository.save(pizza);
        result.redirectTo(this).pizzaListView();

    }

    @Get("remove/{id}")
    public void remove(Integer id) throws OrmException {
        PizzaRepository pizzaRepository = new PizzaRepository();
        pizzaRepository.remove(id);
        result.redirectTo(this).pizzaListView();
    }

    @Post("update")
    public void update(Pizza pizza) throws OrmException {
        PizzaRepository pizzaRepository = new PizzaRepository();

        if (pizzaRepository.findById(pizza.getId()) != null) {
            Pizza p = pizzaRepository.findById(pizza.getId());

            if (pizza.getName() != null) {
                p.setName(pizza.getName());
            }

            if (pizza.getFlavor() != null) {
                p.setFlavor(pizza.getFlavor());
            }

            if (pizza.getIngredients() != null) {
                p.setIngredients(pizza.getIngredients());
            }

            if (pizza.getPrice() != 0) {
                p.setPrice(pizza.getPrice());
            }

            pizzaRepository.update(p);
            result.redirectTo(this).pizzaListView();
        } else {
            result.include("menssage", "Não Existe uma pizza com esse id!");
            result.redirectTo(this).pizzaUpdateView();
        }

    }

    @Post("buscar")
    public void findByName(Pizza pizza) throws OrmException {
        PizzaRepository pizzaRepository = new PizzaRepository();
        List<Pizza> pizzas = pizzaRepository.findByName(pizza.getName());
        result.include("pizzas", pizzas);
        result.of(this).pizzaListView();
    }
    

}
