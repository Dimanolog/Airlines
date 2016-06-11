package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.AbstractFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.UserDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.AircraftModel_;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.User_;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, Long> implements UserDAO {

	protected UserDaoImpl() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleFilterParameters(AbstractFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<User> from) {
		// TODO Auto-generated method stub
	}
	@Override
	public User getUserByLogin(String login)
	{
	 EntityManager em = getEntityManager();
     CriteriaBuilder cb = em.getCriteriaBuilder();
     CriteriaQuery<User> cq = cb.createQuery(getEntityClass());
     Root<User> from = cq.from(getEntityClass());
     cq.select(from);
     cq.where(cb.equal(from.get(User_.login), login));
     TypedQuery<User> q = em.createQuery(cq);
     
     return q.getSingleResult();
 	}
	
	@Override
	public User getUserByEmail(String email)
	{
	 EntityManager em = getEntityManager();
     CriteriaBuilder cb = em.getCriteriaBuilder();
     CriteriaQuery<User> cq = cb.createQuery(getEntityClass());
     Root<User> from = cq.from(getEntityClass());
     cq.select(from);
     cq.where(cb.equal(from.get(User_.email), email));
     TypedQuery<User> q = em.createQuery(cq);
     
     return q.getSingleResult();
 	}
	
}
