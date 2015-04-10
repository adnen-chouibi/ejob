package mBeans;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "securityMB")
@RequestScoped
public class SecurityBean {

	@ManagedProperty(value = "#{userManager}")
	private UserBean userBean;
	String loginURL = "/login.jsf";

	public void checkLogIn() {
		if (userBean == null || !userBean.isLoggedIn()) {
			try {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				context.redirect(context.getRequestContextPath() + loginURL);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}