
package org.javaturk.wap.mvc.login.spring;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.javaturk.wap.mvc.login.domain.User;
import org.javaturk.wap.mvc.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/loginSpring.do")
public class SpringLoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	public String login(Model model, HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("role") String role) {
		Date date = new Date();
		if (username.equals(password)) {
			User user = createUser(username, password, role);
			boolean authenticated = loginService.authenticate(user);
			model.addAttribute("spring", true);
			// model.addAttribute("date", date);
			if (authenticated) {
				session.setAttribute("user", user);
				if (role.equals("admin"))
					return "welcomeAdmin";
				else if (role.equals("poweruser"))
					return "welcomePowerUser";
				else if (role.equals("branchuser"))
					return "welcomeBranchUser";
				else if (role.equals("departmentuser"))
					return "welcomeDepartmentUser";
				else
					return "login";
			} else
				return "login";
		} else
			return "login";
	}

	@ModelAttribute("date")
	public Date getDate() {
		return new Date();
	}

	public User createUser(String username, String password, String role) {
		return new User(username, password, role);
	}
}
