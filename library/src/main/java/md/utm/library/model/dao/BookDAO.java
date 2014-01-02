package md.utm.library.model.dao;

import java.util.List;

import md.utm.library.model.entity.Book;

public interface BookDAO extends GenericDao {

	List<Book> getAllBooks();

	Book findBookByTitle(String bookTitle);

}
