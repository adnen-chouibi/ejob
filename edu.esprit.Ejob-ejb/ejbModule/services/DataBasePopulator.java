package services;

import javax.annotation.PostConstruct;
import javax.ejb.EnterpriseBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Candidate;
import domain.Entreprise;

/**
 * Session Bean implementation class DataBasePopulator
 */
@Singleton
@Startup
public class DataBasePopulator {
	@PersistenceContext(unitName="edu.esprit.Ejob-ejb")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public DataBasePopulator() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		Candidate candidate = new Candidate("adnen@gmail.com", "adnen", "adnen", "adnen", "chouibi");
		Candidate candidate2 = new Candidate("haithem@gmail.com", "haithem", "haithem", "haithem", "rihan");
		Candidate candidate3 = new Candidate("mohamed@gmail.com", "mohamed", "mohamed", "mohamed", "jma3a");
		
		Entreprise entreprise = new Entreprise("adnen07@gmail.com", "adnen07", "admin", "APP4MOB");

		entityManager.persist(candidate);
		entityManager.persist(candidate2);
		entityManager.persist(candidate3);

		entityManager.persist(entreprise);

	}

}
