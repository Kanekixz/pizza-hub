package br.edu.fjn.pizzahub.persistence.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrmPU");
	
	
	private Factory() {
		
	}
	
	public static EntityManager getFactory() {
		return emf.createEntityManager();
	}
	
	public static void closeConetion() {
		emf.close();
	}
}
