package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EnterpriseBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Candidate;
import domain.City;
import domain.Entreprise;
import domain.Job;
import domain.Job.Contract;
import domain.Job.EducationDegree;
import domain.Job.JobType;
import domain.Job.ProfessionalExperience;
import domain.Profession;

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
	private static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
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
		entityManager.flush();
		
		
		String[] scities={"Nabeul","Kairouan","Tunis","Ariana","Sousse","Gasserine","Kef","Tataouin"};
		List<City> citieso=new ArrayList();
		for(String cityname : scities){
			City city=new City(cityname);
			entityManager.persist(city);
			entityManager.flush();
			citieso.add(city);
		}
		String[] sprofessions={"Informatique","Maçon","Massage","Hotellerie","Restauration"};
		List<Profession> professionso=new ArrayList();
		for(String professionname : sprofessions){
			Profession profession=new Profession(professionname);
			entityManager.persist(profession);
			entityManager.flush();
			professionso.add(profession);
		}
		for(int i=0;i<50;i++){
			City city=citieso.get(randInt(0,citieso.size()-1));
			Profession profession=professionso.get(randInt(0,professionso.size()-1));
			Job job=new Job();
			job.setCity(city);
			job.setContract(Contract.JUNIOR);
			job.setCreatedAt(new Date());
			job.setDescription(profession.getName()+" à "+city.getName());
			job.setEducation_degree(EducationDegree.JUNIOR);
			job.setEntreprise(entreprise);
			job.setIs_active(true);
			job.setJob_type(JobType.JUNIOR);
			job.setProfession(profession);
			job.setProfessional_experience(ProfessionalExperience.MANAGER);
			job.setTitle(profession.getName()+" à "+city.getName());
			//Job job=new Job(profession.getName()+" à "+city.getName(), profession.getName()+" à "+city.getName(), true,city, JobType.JUNIOR, Contract.JUNIOR, EducationDegree.SENIOR, ProfessionalExperience.EXECUTIVE,entreprise,new Date(),profession);
			entityManager.persist(job);
		}

	}
}
