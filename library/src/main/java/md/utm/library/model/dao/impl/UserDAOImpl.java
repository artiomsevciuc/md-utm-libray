package md.utm.library.model.dao.impl;

import java.util.List;

import md.utm.library.exception.ObjectsNotFoundException;
import md.utm.library.model.dao.UserDAO;
import md.utm.library.model.entity.Book;
import md.utm.library.model.entity.User;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends GenericDaoImpl implements UserDAO {

	public List<Book> retrieveAllUploadedUserBooks(User user) {
		return getHibernateTemplate().find("from Book b where b.uploader.id=?",
				user.getId());
	}

	public User findUser(String login, String password) {
		List<User> find = getHibernateTemplate().find(
				"from User where email=? and password=?", login, password);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(User.class, login, password);
		}
		return find.iterator().next();
	}

	public List<User> getAllUsers() {
		return getHibernateTemplate().find("from User order by admin desc");
	}

	public User findUser(Integer id) {
		return get(User.class, id);
	}

	public void deleteUser(Integer id) {
		delete(findUser(id));
	}
}
