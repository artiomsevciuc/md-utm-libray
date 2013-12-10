package md.utm.strutsspringhibernate.dao;

import java.util.List;

import md.utm.strutsspringhibernate.model.Books;
import md.utm.strutsspringhibernate.model.User;

public interface UserDAO {
	void createUser(User user);

	void updateUser(User user);

	List<User> retrieveAllUsers();

	List<Books> retrieveAllUploadedUserBooks(User user);

	User findUser(String login, String password);

}
