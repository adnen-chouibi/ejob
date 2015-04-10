package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import services.interfaces.JobServicesLocal;
import domain.Job;

@ManagedBean(name="beancandidat")
@RequestScoped
public class CandidatJobBean {

	@PostConstruct
	public void init(){
		Job job=new Job();
		job.setTitle("restau");
		List<Job> findAllJobs = jobServicesLocal.search(job);
		System.out.println(findAllJobs);
		jobs = findAllJobs;
	}
	//model
	private List<Job> jobs = new ArrayList<>();
	
	@EJB
	private JobServicesLocal jobServicesLocal;
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

}
