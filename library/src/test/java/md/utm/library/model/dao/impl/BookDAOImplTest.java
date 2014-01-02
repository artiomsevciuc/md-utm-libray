package md.utm.library.model.dao.impl;

import java.util.List;

import md.utm.library.model.dao.BookDAO;
import md.utm.library.model.entity.Book;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDAOImplTest {
	@Autowired
	private BookDAO testable;
	@Autowired
	private SessionFactory sessionFactory;
	private Book book;

	@Test
	@Transactional
	public void testCreateBook() {
		book = new Book();
		book.setDescription("This book is about relation between man and uman when the man is veteran of the first war");
		book.setNumberOfDownloads(5);
		book.setPublicaTionDate(new DateTime(1926, 10, 1, 0, 0, 0).toDate());
		book.setTitle("The sun also rises");
		book.setUploadDate(new DateTime(2013, 9, 17, 0, 0, 0).toDate());
		testable.save(book);

		Assert.assertTrue(book.getId() > 0);
	}

	@Test
	@Transactional
	public void testGetAllBooks() {
		testCreateBook();

		List<Book> allBooks = testable.getAllBooks();

		Assert.assertFalse(allBooks.isEmpty());
		Assert.assertEquals(1, allBooks.size());
	}

	@Test
	@Transactional
	public void testFindBookByTitle() {
		testCreateBook();

		Book book = testable.findBookByTitle("The sun also rises");

		Assert.assertNotNull(book);
	}

}
