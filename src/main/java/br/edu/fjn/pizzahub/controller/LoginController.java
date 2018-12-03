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
import br.edu.fjn.pizzahub.model.Login;
import br.edu.fjn.pizzahub.persistence.LoginRepository;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.util.Public;
import br.edu.fjn.pizzahub.util.UserSession;
import javax.inject.Inject;

/**
 *
 * @author Hugo
 */
@Controller
public class LoginController {

    @Inject
    private Result result;
    @Inject
    private UserSession userSession;

    @Public
    @Get("login")
    public void loginView() {

    }

    @Public
    @Get("register")
    public void registerView() {

    }

    @Public
    @Post("cadastrar")
    public void save(Login login) throws OrmException {
        LoginRepository loginRepository = new LoginRepository();

        if (loginRepository.findByUsername(login.getUsername()) == null) {

            loginRepository.save(login);
            result.include("menssage", "Agora faça login!");
            result.redirectTo(this).loginView();

        } else {
            result.include("menssage", "Esse usuario já existe!");
            result.redirectTo(this).registerView();
        }

    }

    @Public
    @Post("logar")
    public void login(Login login) {
        LoginRepository loginRepository = new LoginRepository();

        if (loginRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword()) != null) {
            userSession.setLogged(true);
            result.redirectTo(HomeController.class).homeView();
        } else {
            result.include("menssage", "Usuario ou senha incorretos!");
            result.redirectTo(this).loginView();
        }
    }

    @Get("sair")
    public void logout() {

        userSession.setLogged(false);
        result.include("menssage", "Logout feito com sucesso!");
        result.redirectTo(this).loginView();
    }
}
