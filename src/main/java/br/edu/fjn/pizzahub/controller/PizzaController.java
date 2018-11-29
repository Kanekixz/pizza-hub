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
    
    @Get("remover")
    public void pizzaRemoveView(){
        
    }
    
    @Get("atualizar")
    public void pizzaUpdateView(){
        
    }
    
    @Post("save")
    public void save(Pizza pizza) throws OrmException{
        PizzaRepository pizzaRepository = new PizzaRepository();
        pizzaRepository.save(pizza);
        result.redirectTo(this).pizzaView();
        
    }
    
    @Post("remove")
    public void remove(Pizza pizza) throws OrmException{
       PizzaRepository pizzaRepository = new PizzaRepository();
       pizzaRepository.remove(pizza.getId());
       result.redirectTo(this).pizzaView();
    }
    
    @Post("update")
    public void update(Pizza pizza) throws OrmException{
       PizzaRepository pizzaRepository = new PizzaRepository();
       
       Pizza p = pizzaRepository.findById(pizza.getId());
       
       if(pizza.getName() != null){
           p.setName(pizza.getName());
       }
       
       if(pizza.getFlavor() != null){
           p.setFlavor(pizza.getFlavor());
       }
       
       if(pizza.getIngredients() != null){
           p.setIngredients(pizza.getIngredients());
       }
       
       if(pizza.getPrice() != 0){
           p.setPrice(pizza.getPrice());
       }
      
       pizzaRepository.update(p);
       result.redirectTo(this).pizzaView();
    }
}
