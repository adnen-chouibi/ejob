package domain;

import javax.persistence.Entity;

@Entity
public class Entreprise extends User {

	private static final long serialVersionUID = 1L;
	
	private String company_name;

	public Entreprise() {
		super();
	}	

	public Entreprise(String email, String login, String password, String company_name) {
		super();
		this.setEmail(email);
		this.setLogin(login);
		this.setPassword(password);
		this.company_name = company_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
}
