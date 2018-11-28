package br.edu.fjn.pizzahub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PizzaSize {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id; 
	@JoinColumn(nullable = false)
	@OneToOne
	private Pizza pizza;
	private String pizzaSize;
	
	public PizzaSize() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
	
	
}
