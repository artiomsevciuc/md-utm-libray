package md.utm.library.action.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import md.utm.library.model.dao.UserDAO;
import md.utm.library.model.entity.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class CrudUserAction implements ModelDriven<User> {

	private User user = new User();

	private UserDAO userDAO;

	private List<User> userList;

	private Integer userId;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String addUser() throws Exception {
		user.setCreatedDate(new Date());
		userDAO.save(user);
		if (user.getName() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public String updateUser() {
		userDAO.saveOrUpdate(user);
		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String editUser() {
		String returnType = Action.NONE;
		if (userId != null) {
			ActionContext.getContext().getValueStack().getRoot().remove(user);
			user = getUserDAO().findUser(userId);
			ActionContext.getContext().getValueStack().getRoot().add(user);
			returnType = Action.SUCCESS;
		}
		return returnType;
	}

	public String removeUser() {
		if (userId != null) {
			getUserDAO().deleteUser(userId);
		}
		return Action.SUCCESS;
	}

	// list all users
	public String listAllUsers() {
		userList = userDAO.getAllUsers();
		if (userList == null) {
			userList = new ArrayList<User>();
		}
		return Action.SUCCESS;
	}

}