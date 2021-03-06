package md.utm.library.action.user;

import java.util.Map;

import md.utm.library.model.dao.UserDAO;
import md.utm.library.model.entity.User;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAuthAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private UserDAO userDAO;

	private Boolean error;
	private Map<String, Object> sessionMap;
	private User user;

	@Override
	public String execute() {
		if (email.equals("")) {
			addActionError("Please Enter user email.");
			error = true;
		} else if (password.equals("")) {
			addActionError("Please Enter password.");
			error = true;
		} else if (email.equalsIgnoreCase(password)) {
			addActionError("Email and password should be different.");
			error = true;
		} else if (findUser() == null) {
			error = true;
		} else {
			error = false;
			sessionMap.put("userName", user.getName());
			sessionMap.put("logged", true);
			sessionMap.put("admin", user.isAdmin());
		}

		if (error) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	public String logOut() {
		if (sessionMap.containsKey("userName")) {
			sessionMap.remove("userName");
			sessionMap.put("logged", false);
			sessionMap.put("admin", false);
		}
		return SUCCESS;
	}

	private User findUser() {
		user = userDAO.findUser(email, password);
		return user;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

}
