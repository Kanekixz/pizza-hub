package br.edu.fjn.pizzahub.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.pizzahub.persistence.util.Factory;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.model.Client;

public class ClientRepository {

    public void save(Client client) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.persist(client);
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

    public void update(Client client) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.merge(client);
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

    public Client findById(Integer id) {
        EntityManager em = Factory.getFactory();
        Client client = em.find(Client.class, id);
        em.close();
        return client;
    }

    public void remove(Integer id) throws OrmException {
        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();
        Client client = findById(id);

        try {

            em.remove(client);
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

    public List<Client> listAll() {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Client.class);
        List<Client> clients = criteria.list();
        em.close();
        return clients;
    }

    public List<Client> findByName(String name) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Client.class);
        criteria.createAlias("person", "p");
        criteria.add(Restrictions.ilike("p.name", name, MatchMode.ANYWHERE));
        List<Client> clients = criteria.list();
        em.close();
        return clients;
    }

    public Client findByCpf(String cpf) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Client.class);
        criteria.createAlias("person", "p");
        criteria.add(Restrictions.ilike("p.cpf", cpf, MatchMode.EXACT));
        Client client = (Client) criteria.uniqueResult();
        em.close();
        return client;
    }

    public Client findByEmail(String email) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Client.class);
        criteria.createAlias("person", "p");
        criteria.createAlias("p.contact", "c");
        criteria.add(Restrictions.ilike("c.email", email, MatchMode.EXACT));
        Client client = (Client) criteria.uniqueResult();
        em.close();
        return client;
    }

    public Client findByPhone(String phone) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Client.class);
        criteria.createAlias("person", "p");
        criteria.createAlias("p.contact", "c");
        criteria.add(Restrictions.ilike("c.phone", phone, MatchMode.EXACT));
        Client client = (Client) criteria.uniqueResult();
        em.close();
        return client;
    }

}
