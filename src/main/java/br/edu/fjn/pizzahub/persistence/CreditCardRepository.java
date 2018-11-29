package br.edu.fjn.pizzahub.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.pizzahub.persistence.util.Factory;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.model.CreditCard;

public class CreditCardRepository {

    public void save(CreditCard creditCard) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.persist(creditCard);
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

    public void update(CreditCard creditCard) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.merge(creditCard);
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

    public CreditCard findById(Integer id) {
        EntityManager em = Factory.getFactory();
        CreditCard creditCard = em.find(CreditCard.class, id);
        em.close();
        return creditCard;
    }

    public void remove(Integer id) throws OrmException {
        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();
        CreditCard creditCard = findById(id);

        try {

            em.remove(creditCard);
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

    public List<CreditCard> listAll() {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(CreditCard.class);
        List<CreditCard> creditCards = criteria.list();
        em.close();
        return creditCards;
    }

    public CreditCard findByNumber(String number) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(CreditCard.class);
        criteria.add(Restrictions.ilike("number", number, MatchMode.EXACT));
        CreditCard creditCard = (CreditCard) criteria.uniqueResult();
        em.close();
        return creditCard;
    }

    public List<CreditCard> findByOwnerName(String ownerName) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(CreditCard.class);
        criteria.add(Restrictions.ilike("ownerName", ownerName, MatchMode.ANYWHERE));
        List<CreditCard> creditCards = criteria.list();
        em.close();
        return creditCards;
    }

    public List<CreditCard> findByFlag(String flag) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(CreditCard.class);
        criteria.add(Restrictions.ilike("flag", flag, MatchMode.ANYWHERE));
        List<CreditCard> creditCards = criteria.list();
        em.close();
        return creditCards;
    }

}
