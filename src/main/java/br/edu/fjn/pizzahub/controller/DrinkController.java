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
import br.edu.fjn.pizzahub.persistence.DrinkRepository;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Hugo
 */
@Controller
@Path("bebida")
public class DrinkController {

    @Inject
    Result result;

    @Get("")
    public void drinkView() {

    }

    @Get("adicionar")
    public void drinkSaveView() {

    }

    @Get("atualizar")
    public void drinkUpdateView() {

    }

    @Get("listar")
    public void drinkListView() {
        DrinkRepository drinkRepository = new DrinkRepository();
        List<Drink> drinks = drinkRepository.listAll();
        result.include("drinks", drinks);
    }

    @Post("save")
    public void save(Drink drink) throws OrmException {
        DrinkRepository drinkRepository = new DrinkRepository();
        drinkRepository.save(drink);
        result.redirectTo(this).drinkListView();

    }

    @Post("update")
    public void update(Drink drink) throws OrmException {
        DrinkRepository drinkRepository = new DrinkRepository();

        if (drinkRepository.findById(drink.getId()) != null) {
            Drink d = drinkRepository.findById(drink.getId());

            if (drink.getName() != null) {
                d.setName(drink.getName());
            }

            if (drink.getValue() != null) {
                d.setValue(drink.getValue());
            }

            if (drink.getPrice() != null) {
                d.setPrice(drink.getPrice());
            }

            drinkRepository.update(d);
            result.redirectTo(this).drinkListView();
        } else {
            result.include("menssage", "Não Existe uma Bebida com esse id!");
            result.redirectTo(this).drinkUpdateView();
        }

    }

    @Get("remove/{id}")
    public void remove(Integer id) throws OrmException {
        Drink drink = new Drink();
        drink.setId(id);
        DrinkRepository drinkRepository = new DrinkRepository();
        drinkRepository.remove(drink.getId());
        result.redirectTo(this).drinkListView();
    }

    @Post("buscar")
    public void findByName(Drink drink) throws OrmException {
        DrinkRepository drinkRepository = new DrinkRepository();
        List<Drink> drinks = drinkRepository.findByName(drink.getName());
        result.include("drinks", drinks);
        result.of(this).drinkListView();
    }

}
