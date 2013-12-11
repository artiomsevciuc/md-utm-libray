package md.utm.strutsspringhibernate.dao;

import java.util.List;

import md.utm.strutsspringhibernate.model.Book;
import md.utm.strutsspringhibernate.model.User;

public interface UserDAO extends GenericDao {

	List<Book> retrieveAllUploadedUserBooks(User user);

	User findUser(String login, String password);

}
