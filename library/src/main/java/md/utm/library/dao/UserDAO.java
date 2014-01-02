package md.utm.library.dao;

import java.util.List;

import md.utm.library.model.Book;
import md.utm.library.model.User;

public interface UserDAO extends GenericDao {

	List<Book> retrieveAllUploadedUserBooks(User user);

	User findUser(String login, String password);

}
