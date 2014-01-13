package md.utm.library.action.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import md.utm.library.model.dao.UserDAO;
import md.utm.library.model.entity.User;

import com.opensymphony.xwork2.ModelDriven;

public class CrudUserAction implements ModelDriven<User> {

	private final User user = new User();

	private UserDAO userDAO;

	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

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

	// list all users
	public String listAllUsers() throws Exception {
		userList = userDAO.getAllUsers();
		if (userList == null) {
			userList = new ArrayList<User>();
		}

		return "success";

	}

}