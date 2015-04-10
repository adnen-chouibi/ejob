package mBeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import domain.Candidate;
import domain.Entreprise;
import domain.User;

@ManagedBean(name="beanOne")
@SessionScoped
public class UserBean {
	// model
	private Candidate candidate = new Candidate();
	private Entreprise entreprise = new Entreprise();
	
	private List<User> users = new ArrayList<>();
	private User userLoggedIn = new User();
	private String login;
	private String password;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// methods
	/*public String doAddEmployee() {
		userServicesLocal.addUser(employee);
		return "";
	}*/

	public String doLogin() {
		userLoggedIn = userServicesLocal.login(login,password);
		
		if (userLoggedIn != null) {		

			if (userLoggedIn instanceof Candidate) {
				System.out.println("candidate");
				System.out.println(userLoggedIn.getLogin());
				
				candidate = (Candidate) userLoggedIn;
				return "/candidat/index";
			} else {
				
				entreprise = (Entreprise) userLoggedIn;
				return "/entreprise/index";
			}
		} else {
			return "/error";
		}
	}
	
	 public boolean isLoggedIn() {

	      return userLoggedIn != null;

	   }
/*
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
*/
/*	public List<User> getUsers() {
		users = userServicesLocal.findAllUsers();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
*/
	public User getUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(User userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

}
