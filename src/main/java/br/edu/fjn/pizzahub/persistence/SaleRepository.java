package br.edu.fjn.pizzahub.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.pizzahub.persistence.util.Factory;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.model.Sale;

public class SaleRepository {

    public void save(Sale sale) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.persist(sale);
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

    public void update(Sale sale) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.merge(sale);
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

    public Sale findById(Integer id) {
        EntityManager em = Factory.getFactory();
        Sale sale = em.find(Sale.class, id);
        em.close();
        return sale;
    }

    public void remove(Integer id) throws OrmException {
        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();
        Sale sale = findById(id);

        try {

            em.remove(sale);
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

    public List<Sale> listAll() {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByEmployeeName(String name) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("employee", "e");
        criteria.createAlias("e.person", "p");
        criteria.add(Restrictions.ilike("p.name", name, MatchMode.ANYWHERE));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByEmployeeCpf(String cpf) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("employee", "e");
        criteria.createAlias("e.person", "p");
        criteria.add(Restrictions.ilike("p.cpf", cpf, MatchMode.EXACT));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByEmployeeFunction(String function) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("employee", "e");
        criteria.add(Restrictions.ilike("e.function", function, MatchMode.ANYWHERE));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByClientName(String name) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("client", "c");
        criteria.createAlias("c.person", "p");
        criteria.add(Restrictions.ilike("p.name", name, MatchMode.ANYWHERE));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByClientCpf(String cpf) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("client", "c");
        criteria.createAlias("c.person", "p");
        criteria.add(Restrictions.ilike("p.cpf", cpf, MatchMode.EXACT));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByPaymentMethod(String paymentMethod) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.add(Restrictions.ilike("paymentMethod", paymentMethod, MatchMode.ANYWHERE));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByCreditCardNumber(String creditCardNumber) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("creditCard", "c");
        criteria.add(Restrictions.ilike("c.number", creditCardNumber, MatchMode.EXACT));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByDrinkName(String drinkName) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("drinks", "d");
        criteria.add(Restrictions.ilike("d.name", drinkName, MatchMode.ANYWHERE));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

    public List<Sale> findByPizzaName(String pizzaName) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Sale.class);
        criteria.createAlias("pizzas", "p");
        criteria.createAlias("p.pizza", "pizza");
        criteria.add(Restrictions.ilike("pizza.name", pizzaName, MatchMode.ANYWHERE));
        List<Sale> sales = criteria.list();
        em.close();
        return sales;
    }

}
