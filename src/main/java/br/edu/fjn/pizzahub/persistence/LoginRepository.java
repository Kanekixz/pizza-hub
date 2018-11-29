package br.edu.fjn.pizzahub.persistence;

import br.edu.fjn.pizzahub.persistence.util.Factory;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.model.Login;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class LoginRepository {

    public void save(Login login) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.persist(login);
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

    public void update(Login login) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.merge(login);
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
    
    public Login findById(Integer id) {
        EntityManager em = Factory.getFactory();
        Login login = em.find(Login.class, id);
        em.close();
        return login;
    }
    
    public List<Login> listAll() {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Login.class);
        List<Login> logins = criteria.list();
        em.close();
        return logins;
    }
    
    public Login findByUsername(String username) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Login.class);
        criteria.add(Restrictions.ilike("username", username, MatchMode.EXACT));
        Login login = (Login) criteria.uniqueResult();
        em.close();
        return login;
    }
    
    public Login findByUsernameAndPassword(String username, String password) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Login.class);
        Criterion c1 = Restrictions.ilike("username", username, MatchMode.EXACT);
        Criterion c2 = Restrictions.like("password", password, MatchMode.EXACT);
        criteria.add(Restrictions.and(c1, c2));
        Login login = (Login) criteria.uniqueResult();
        em.close();
        return login;
    }
    
    public void remove(Integer id) throws OrmException {
        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();
        Login login = findById(id);

        try {

            em.remove(login);
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
