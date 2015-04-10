package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String title;
	private String description;
	private Boolean is_active;
	private City city;
	@Enumerated(EnumType.STRING)
	private JobType job_type;
	@Enumerated(EnumType.STRING)
	private Contract contract;
	@Enumerated(EnumType.STRING)
	private EducationDegree education_degree;
	@Enumerated(EnumType.STRING)
	private ProfessionalExperience professional_experience;


	private Entreprise entreprise;

	
	private Date createdAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	@Temporal(TemporalType.DATE)
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "entreprise_id", nullable = false)
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Job() {
		super();
	}

	public Job(String title, String description, Boolean is_active, City city,
			JobType job_type, Contract contract,
			EducationDegree education_degree,
			ProfessionalExperience professional_experience,
			Entreprise entreprise, Date createdAt, Profession profession) {
		super();
		this.title = title;
		this.description = description;
		this.is_active = is_active;
		this.city = city;
		this.job_type = job_type;
		this.contract = contract;
		this.education_degree = education_degree;
		this.professional_experience = professional_experience;
		this.entreprise = entreprise;
		this.createdAt = createdAt;
		this.profession = profession;
	}

	public enum JobType {
		JUNIOR, SENIOR, MANAGER, EXECUTIVE
	}

	public enum Contract {
		JUNIOR, SENIOR, MANAGER, EXECUTIVE
	}

	public enum EducationDegree {
		JUNIOR, SENIOR, MANAGER, EXECUTIVE
	}

	public enum ProfessionalExperience {
		JUNIOR, SENIOR, MANAGER, EXECUTIVE
	}

	private Profession profession;

	public JobType getJob_type() {
		return job_type;
	}

	public void setJob_type(JobType job_type) {
		this.job_type = job_type;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public EducationDegree getEducation_degree() {
		return education_degree;
	}

	public void setEducation_degree(EducationDegree education_degree) {
		this.education_degree = education_degree;
	}

	public ProfessionalExperience getProfessional_experience() {
		return professional_experience;
	}

	public void setProfessional_experience(
			ProfessionalExperience professional_experience) {
		this.professional_experience = professional_experience;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id", nullable = true)
	public City getCity() {
		return city;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profession_id", nullable = false)
	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

}
