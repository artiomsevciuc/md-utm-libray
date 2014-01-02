package md.utm.library.model.dao.impl;

import java.util.List;

import md.utm.library.exception.ObjectsNotFoundException;
import md.utm.library.model.dao.AuthorDAO;
import md.utm.library.model.entity.Author;
import md.utm.library.model.entity.Book;

@SuppressWarnings("unchecked")
public class AuthorDAOImpl extends GenericDaoImpl implements AuthorDAO {

	public List<Book> retrieveAllAuthorsBooks(Author author) {
		return getHibernateTemplate().find("from Book b where b.author.id=?",
				author.getId());
	}

	public Author findAuthor(String name, String surname) {
		List<Author> find = getHibernateTemplate().find(
				"from Author a where name=? and surname=?", name, surname);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(Author.class, name, surname);
		}
		return find.iterator().next();
	}

	public List<Author> getAllAuthors() {
		return getHibernateTemplate().find("from Author");
	}

}
