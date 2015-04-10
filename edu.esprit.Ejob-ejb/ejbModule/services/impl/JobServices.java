package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import domain.Job;
import services.interfaces.JobServicesLocal;

@Stateless
public class JobServices implements JobServicesLocal {
	
	@PersistenceContext(unitName="edu.esprit.Ejob-ejb")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> findAllJobs() {
		return entityManager.createQuery("select j from Job j").getResultList();
	}
	@Override
	public List<Job> search(Job job) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Job> criteriaQuery = builder.createQuery(Job.class);
		Root<Job> jobRoot = criteriaQuery.from(Job.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();
		if (job.getTitle() != null) {
			predicateList.add(builder.like(jobRoot.<String> get("title"),
					"%"+job.getTitle()+"%"));
		}
		/*
		if (user.getName() != null) {
			predicateList.add(builder.like(userRoot.<String> get("name"),
					user.getName()));
		}
		if (user.getPassword() != null) {
			predicateList.add(builder.like(userRoot.<String> get("password"),
					user.getPassword()));
		}
		List<Role> roles = user.getRoles();
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				SetJoin<User, Role> roleJoin = userRoot.joinSet("roles");
				predicateList.add(builder.like(roleJoin.<String> get("name"),
						role.getName()));
			}
		}
*/
		criteriaQuery.select(jobRoot).where(
				builder.and(predicateList.toArray(new Predicate[predicateList
						.size()])));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
