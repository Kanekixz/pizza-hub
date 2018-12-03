package br.edu.fjn.pizzahub.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserSession implements Serializable{

	private boolean isLogged;

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	
	
}
