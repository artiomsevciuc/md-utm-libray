package md.utm.library.model.dao.impl;

import java.util.List;

import md.utm.library.exception.ObjectsNotFoundException;
import md.utm.library.model.dao.BookDAO;
import md.utm.library.model.entity.Author;
import md.utm.library.model.entity.Book;

@SuppressWarnings("unchecked")
public class BookDAOImpl extends GenericDaoImpl implements BookDAO {

	public List<Book> getAllBooks() {
		return getHibernateTemplate().find("from Book");
	}

	public Book findBookByTitle(String bookTitle) {
		List<Book> find = getHibernateTemplate().find(
				"from Book where title=?", bookTitle);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(Author.class, bookTitle);
		}
		return find.iterator().next();
	}

}
