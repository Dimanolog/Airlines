package by.trainings.java8.year2016.dzshnipko.airlines.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.trainings.java8.year2016.dzshnipko.airlines.dao.filters.UserFilter;
import by.trainings.java8.year2016.dzshnipko.airlines.dao.interfaces.UserDAO;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.UserProfile;
import by.trainings.java8.year2016.dzshnipko.airlines.datamodel.entities.UserProfile_;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<UserProfile, Long, UserFilter> implements UserDAO {

	protected UserDaoImpl() {
		super(UserProfile.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserProfile getUserByLogin(String login) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserProfile> cq = cb.createQuery(getEntityClass());
		Root<UserProfile> from = cq.from(getEntityClass());
		cq.select(from);
		cq.where(cb.equal(from.get(UserProfile_.login), login));
		TypedQuery<UserProfile> q = em.createQuery(cq);

		return checkSingleResult(q);
	}

	@Override
	public UserProfile getUserByEmail(String email) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserProfile> cq = cb.createQuery(getEntityClass());
		Root<UserProfile> from = cq.from(getEntityClass());
		cq.select(from);
		cq.where(cb.equal(from.get(UserProfile_.email), email));
		TypedQuery<UserProfile> q = em.createQuery(cq);
		return checkSingleResult(q);
	}

	private UserProfile checkSingleResult(TypedQuery<UserProfile> q) {
		UserProfile userProfile=null;
		try{
			userProfile=q.getSingleResult();
		}catch(NoResultException ex){
			
		}
		
		return userProfile;
	}

	@Override
	protected void handleFilterParameters(UserFilter filter, CriteriaBuilder cb, CriteriaQuery<?> cq,
			Root<UserProfile> from) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void fetchLazyInitilization(UserFilter filter, Root<UserProfile> from) {
		// TODO Auto-generated method stub
		
	}

}
