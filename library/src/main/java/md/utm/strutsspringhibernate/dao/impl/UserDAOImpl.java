package md.utm.strutsspringhibernate.dao.impl;

import java.util.List;

import md.utm.strutsspringhibernate.dao.UserDAO;
import md.utm.strutsspringhibernate.model.Books;
import md.utm.strutsspringhibernate.model.User;

public class UserDAOImpl extends GenericDaoImpl implements UserDAO {

	public List<Books> retrieveAllUploadedUserBooks(User user) {
		return getHibernateTemplate().find(
				"from Customer where email=? and password=?", user.getEmail(),
				user.getPassword());
	}

	public User findUser(String login, String password) {
		List<User> find = getHibernateTemplate().find(
				"from User where email=? and password=?", login, password);
		if (find.isEmpty()) {

		}
		return find.iterator().next();
	}
}
