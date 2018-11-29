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
import br.edu.fjn.pizzahub.model.Drink;

public class DrinkRepository {

    public void save(Drink drink) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.persist(drink);
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

    public void update(Drink drink) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.merge(drink);
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

    public Drink findById(Integer id) {
        EntityManager em = Factory.getFactory();
        Drink drink = em.find(Drink.class, id);
        em.close();
        return drink;
    }

    public void remove(Integer id) throws OrmException {
        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();
        Drink drink = findById(id);

        try {

            em.remove(drink);
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

    public List<Drink> listAll() {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Drink.class);
        List<Drink> drinks = criteria.list();
        em.close();
        return drinks;
    }

    public List<Drink> findByName(String name) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Drink.class);
        criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        List<Drink> drinks = criteria.list();
        em.close();
        return drinks;
    }

    public List<Drink> findByValue(String value) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Drink.class);
        criteria.add(Restrictions.ilike("value", value, MatchMode.ANYWHERE));
        List<Drink> drinks = criteria.list();
        em.close();
        return drinks;
    }

    public Drink findByNameAndValue(String name, String value) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Drink.class);
        Criterion c1 = Restrictions.ilike("name", name, MatchMode.EXACT);
        Criterion c2 = Restrictions.ilike("value", value, MatchMode.ANYWHERE);
        criteria.add(Restrictions.and(c1, c2));
        Drink drink = (Drink) criteria.uniqueResult();
        em.close();
        return drink;
    }

}
