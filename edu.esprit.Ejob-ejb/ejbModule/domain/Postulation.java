package domain;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Postulation
 *
 */
@Entity

public class Postulation implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Postulation() {
		super();
	}
	private Integer id;
	private Job job;
	private Candidate candidate;
	private Date createdAt;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "job_id", nullable = false)
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "candidate_id", nullable = false)
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
