package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domain.Job;

@Local
public interface JobServicesLocal {
	
	List<Job> findAllJobs();

	List<Job> search(Job job);
	
}
