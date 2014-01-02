package md.utm.library.action.user;

import md.utm.library.model.dao.UserDAO;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAuthAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private UserDAO userDAO;

	private Boolean error;

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
		} else if (findCustomer() == null) {
			error = true;
		} else {
			error = false;
		}

		if (error) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	private Object findCustomer() {
		return userDAO.findUser(email, password);
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

}
