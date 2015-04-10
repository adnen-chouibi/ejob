package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Job;
import services.interfaces.JobServicesLocal;

@Stateless
public class JobServices implements JobServicesLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> findAllJobs() {
		return entityManager.createQuery("select j from Job j").getResultList();
	}

}
