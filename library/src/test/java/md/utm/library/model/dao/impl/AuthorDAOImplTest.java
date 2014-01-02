package md.utm.library.model.dao.impl;

import java.util.List;

import md.utm.library.model.dao.AuthorDAO;
import md.utm.library.model.entity.Author;
import md.utm.library.model.entity.Book;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorDAOImplTest {

	@Autowired
	private AuthorDAO testable;
	@Autowired
	private SessionFactory sessionFactory;
	private Author author;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Transactional
	public void testCreateAuthor() {
		author = new Author();
		author.setBirthDate(new DateTime(1899, 6, 21, 0, 0, 0).toDate());
		author.setName("Ernest");
		author.setSurname("Hemingway");
		author.setRipDate(new DateTime(1899, 6, 21, 0, 0, 0).toDate());
		Assert.assertNull(author.getId());
		testable.save(author);
		Assert.assertTrue(author.getId() > 0);
	}

	@Test
	@Transactional
	public void testAddBookToAuthor() {
		testCreateAuthor();
		Book book = new Book();
		book.setDescription("This book is about relation between man and uman when the man is veteran of the first war");
		book.setNumberOfDownloads(5);
		book.setPublicaTionDate(new DateTime(1926, 10, 1, 0, 0, 0).toDate());
		book.setTitle("The sun also rises");
		book.setUploadDate(new DateTime(2013, 9, 17, 0, 0, 0).toDate());
		book.setAuthor(author);
		testable.save(book);

		List<Book> retrieveAllUploadedUserBooks = testable
				.retrieveAllAuthorsBooks(author);

		Assert.assertFalse(retrieveAllUploadedUserBooks.isEmpty());
		Assert.assertEquals(1, retrieveAllUploadedUserBooks.size());
	}

	@Test
	@Transactional
	public void testFindAllAuthors() {
		testCreateAuthor();

		List<Author> allAuthors = testable.getAllAuthors();

		Assert.assertFalse(allAuthors.isEmpty());
		Assert.assertEquals(1, allAuthors.size());
	}

	@Test
	@Transactional
	public void testFindAuthorsByNameSurname() {
		testCreateAuthor();

		Author findAuthor = testable.findAuthor("Ernest", "Hemingway");
		Assert.assertNotNull(findAuthor);
	}

}
