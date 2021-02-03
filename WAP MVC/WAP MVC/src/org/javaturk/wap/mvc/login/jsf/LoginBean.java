package org.javaturk.wap.mvc.login.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.javaturk.wap.mvc.login.domain.User;
import org.javaturk.wap.mvc.login.service.LoginService;
import org.javaturk.wap.mvc.login.service.LoginServiceFactory;
import org.javaturk.wap.mvc.login.service.LoginServiceI;
import org.javaturk.wap.mvc.login.util.WeldUtil;

@ManagedBean
@RequestScoped
public class LoginBean {
	private String username = "username";
	private String password;
	private String role;

	@Inject
	LoginServiceI loginService;

	public LoginBean() {
//		loginService = new LoginService();
//		LoginServiceFactory lsf = LoginServiceFactory.getInstance();
//		loginService = lsf.getLoginService();
//		WeldUtil wd = WeldUtil.INSTANCE;
//		loginService = (LoginServiceI) wd.getBean(LoginService.class);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String login() {
		User user = new User(username, password, role);
		boolean b = loginService.authenticate(user);
		String welcomePage = "";
		if (b) {
			if (role.equals("admin")) {
				welcomePage = "welcomeAdmin";
			} else if (role.equals("poweruser")) {
				welcomePage = "welcomePowerUser";
			} else if (role.equals("branchuser")) {
				welcomePage = "welcomeBranchUser";
			} else if (role.equals("departmentuser")) {
				welcomePage = "welcomeDepartmentUser";
			}
		}
		return welcomePage;
	}
}
