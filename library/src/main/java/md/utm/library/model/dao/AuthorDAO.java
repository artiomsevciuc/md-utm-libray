package md.utm.library.model.dao;

import java.util.List;

import md.utm.library.model.entity.Author;
import md.utm.library.model.entity.Book;

public interface AuthorDAO extends GenericDao {

	List<Book> retrieveAllAuthorsBooks(Author author);

	Author findAuthor(String name, String surname);

	List<Author> getAllAuthors();
}
