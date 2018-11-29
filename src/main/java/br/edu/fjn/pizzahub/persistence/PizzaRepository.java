package br.edu.fjn.pizzahub.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.pizzahub.persistence.util.Factory;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.model.Pizza;

public class PizzaRepository {

    public void save(Pizza pizza) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.persist(pizza);
            em.getTransaction().commit();
        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                throw new OrmException("Ocorreu um erro interno!");
            }
        } finally {

            em.close();
        }
    }

    public void update(Pizza pizza) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.merge(pizza);
            em.getTransaction().commit();
        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                throw new OrmException("Ocorreu um erro interno!");
            }

        } finally {

            em.close();
        }
    }

    public Pizza findById(Integer id) {
        EntityManager em = Factory.getFactory();
        Pizza pizza = em.find(Pizza.class, id);
        em.close();
        return pizza;
    }

    public List<Pizza> listAll() {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Pizza.class);
        List<Pizza> pizzas = criteria.list();
        em.close();
        return pizzas;
    }

    public List<Pizza> findByName(String name) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Pizza.class);
        criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        List<Pizza> pizzas = criteria.list();
        em.close();
        return pizzas;
    }

    public List<Pizza> findByFlavor(String flavor) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Pizza.class);
        criteria.add(Restrictions.ilike("flavor", flavor, MatchMode.ANYWHERE));
        List<Pizza> pizzas = criteria.list();
        em.close();
        return pizzas;
    }

    public List<Pizza> findByIngredient(String ingredient) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Pizza.class);
        criteria.add(Restrictions.ilike("ingredients", ingredient, MatchMode.ANYWHERE));
        List<Pizza> pizzas = criteria.list();
        em.close();
        return pizzas;
    }

    public Pizza findByNameAndFlavor(String name, String flavor) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Pizza.class);
        Criterion c1 = Restrictions.ilike("name", name, MatchMode.EXACT);
        Criterion c2 = Restrictions.ilike("flavor", flavor, MatchMode.EXACT);
        criteria.add(Restrictions.and(c1, c2));
        Pizza pizza = (Pizza) criteria.uniqueResult();
        em.close();
        return pizza;
    }

    public void remove(Integer id) throws OrmException {
        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();
        Pizza pizza = findById(id);

        try {
            em.remove(em.getReference(Pizza.class, pizza.getId()));
            em.getTransaction().commit();
        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                throw new OrmException("Ocorreu um erro interno!");
            }

        } finally {

            em.close();
        }
    }

}
