package md.utm.library.action.user;

import java.util.Date;

import md.utm.library.model.dao.UserDAO;
import md.utm.library.model.entity.User;

import com.opensymphony.xwork2.ModelDriven;

public class CrudUserAction implements ModelDriven<User> {

	User user = new User();

	UserDAO userDAO;

	public User getModel() {
		return user;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public String addUser() throws Exception {
		user.setCreatedDate(new Date());
		userDAO.save(user);
		if (user.getName() != null) {
			return "success";
		}
		return "error";
	}

}