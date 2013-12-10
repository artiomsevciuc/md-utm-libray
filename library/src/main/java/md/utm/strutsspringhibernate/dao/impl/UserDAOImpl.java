package md.utm.strutsspringhibernate.dao.impl;

import java.util.List;

import md.utm.strutsspringhibernate.dao.UserDAO;
import md.utm.strutsspringhibernate.model.Books;
import md.utm.strutsspringhibernate.model.User;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	public void createUser(User user) {
		getHibernateTemplate().save(user);

	}

	public void updateUser(User user) {
		getHibernateTemplate().update(user);
	}

	public List<User> retrieveAllUsers() {
		return getHibernateTemplate().find("from User");
	}

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
