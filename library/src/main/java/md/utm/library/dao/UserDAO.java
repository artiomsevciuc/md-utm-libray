package md.utm.library.dao;

import java.util.List;

import md.utm.library.entity.Book;
import md.utm.library.entity.User;

public interface UserDAO extends GenericDao {

	List<Book> retrieveAllUploadedUserBooks(User user);

	User findUser(String login, String password);

}
