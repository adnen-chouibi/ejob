package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import services.interfaces.JobServicesLocal;
import domain.Job;

@ManagedBean
@RequestScoped
public class JobBean {
	
	//model
	private List<Job> jobs = new ArrayList<>();
	
	@ManagedProperty(value = "#{beanOne}")
	private UserBean userBean;
	
	@EJB
	private JobServicesLocal jobServicesLocal;
	
	public List<Job> getJobs() {
		List<Job> findAllJobs = jobServicesLocal.findAllJobs();
		jobs = findAllJobs;
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
