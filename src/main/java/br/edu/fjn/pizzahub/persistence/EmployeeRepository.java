package br.edu.fjn.pizzahub.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.pizzahub.persistence.util.Factory;
import br.edu.fjn.pizzahub.persistence.util.OrmException;
import br.edu.fjn.pizzahub.model.Employee;
import org.hibernate.criterion.Criterion;

public class EmployeeRepository {

    public void save(Employee employee) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.persist(employee);
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

    public void update(Employee employee) throws OrmException {

        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();

        try {

            em.merge(employee);
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

    public Employee findById(Integer id) {
        EntityManager em = Factory.getFactory();
        Employee employee = em.find(Employee.class, id);
        em.close();
        return employee;
    }

    public void remove(Integer id) throws OrmException {
        EntityManager em = Factory.getFactory();
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);

        try {

            em.remove(employee);
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

    public List<Employee> listAll() {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Employee.class);
        List<Employee> employees = criteria.list();
        em.close();
        return employees;
    }

    public List<Employee> findByName(String name) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("person", "p");
        criteria.add(Restrictions.ilike("p.name", name, MatchMode.ANYWHERE));
        List<Employee> employees = criteria.list();
        em.close();
        return employees;
    }

    public Employee findByCpf(String cpf) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("person", "p");
        criteria.add(Restrictions.ilike("p.cpf", cpf, MatchMode.EXACT));
        Employee employee = (Employee) criteria.uniqueResult();
        em.close();
        return employee;
    }

    public Employee findByEmail(String email) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("person", "p");
        criteria.createAlias("p.contact", "c");
        criteria.add(Restrictions.ilike("c.email", email, MatchMode.EXACT));
        Employee employee = (Employee) criteria.uniqueResult();
        em.close();
        return employee;
    }

    public Employee findByPhone(String phone) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("person", "p");
        criteria.createAlias("p.contact", "c");
        criteria.add(Restrictions.ilike("c.phone", phone, MatchMode.EXACT));
        Employee employee = (Employee) criteria.uniqueResult();
        em.close();
        return employee;
    }
    
    public List<Employee> findByNameAndFunction(String name, String function) {
        EntityManager em = Factory.getFactory();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.createAlias("person", "p");
        Criterion c1 = Restrictions.ilike("p.name", name, MatchMode.ANYWHERE);
        Criterion c2 = Restrictions.ilike("function", function, MatchMode.ANYWHERE);
        criteria.add(Restrictions.and(c1, c2));
        List<Employee> employees = criteria.list();
        em.close();
        return employees;
    }

}
