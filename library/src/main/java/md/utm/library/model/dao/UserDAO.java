package md.utm.library.model.dao;

import java.util.List;

import md.utm.library.model.entity.Book;
import md.utm.library.model.entity.User;

public interface UserDAO extends GenericDao {

	List<Book> retrieveAllUploadedUserBooks(User user);

	User findUser(String login, String password);

}
