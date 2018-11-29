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
import br.edu.fjn.pizzahub.dao.PizzaDAO;
import br.edu.fjn.pizzahub.dao.util.OrmException;
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
        PizzaDAO pizzaDAO = new PizzaDAO();
        pizzaDAO.save(pizza);
        result.redirectTo(this).pizzaView();
        
    }
    
    @Post("remove")
    public void remove(Pizza pizza) throws OrmException{
       PizzaDAO pizzaDAO = new PizzaDAO();
       pizzaDAO.remove(pizza.getId());
       result.redirectTo(this).pizzaView();
    }
    
    @Post("update")
    public void update(Pizza pizza) throws OrmException{
       PizzaDAO pizzaDAO = new PizzaDAO();
       pizzaDAO.update(pizza);
       result.redirectTo(this).pizzaView();
    }
}
