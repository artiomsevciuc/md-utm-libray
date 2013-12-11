package md.utm.strutsspringhibernate.dao.impl;

import java.util.List;

import md.utm.strutsspringhibernate.dao.UserDAO;
import md.utm.strutsspringhibernate.exception.ObjectsNotFoundException;
import md.utm.strutsspringhibernate.model.Book;
import md.utm.strutsspringhibernate.model.User;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
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
public class UserDAOImplTest {

	@Autowired
	private UserDAO testable;
	@Autowired
	private SessionFactory sessionFactory;
	private User user;

	@Test
	@Transactional
	public void testCreateUser() {
		user = new User();
		user.setCreatedDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
		user.setEmail("ion@mail.ru");
		user.setName("Ion");
		user.setPassword("ion83");
		user.setSurname("Bushmaciu");
		testable.save(user);
		Assert.assertTrue(user.getId() > 0);
	}

	@Test
	@Transactional
	public void testUpdateUser() {
		testCreateUser();
		User foundUser = testable.get(User.class, user.getId());
		Assert.assertNotNull(foundUser);
		foundUser.setName("Andrei");
		testable.saveOrUpdate(foundUser);
		foundUser = testable.get(User.class, user.getId());
		Assert.assertNotNull(foundUser);
		Assert.assertEquals("Andrei", foundUser.getName());
	}

	@Test
	@Transactional
	public void testRetrieveAllUploadedUserBooks() {
		testCreateUser();
		Book book = new Book();
		book.setDescription("This book is about the times when honor means a lot for the people who fought for honor and love");
		book.setNumberOfDownloads(5);
		book.setPublicaTionDate(new DateTime(1820, 5, 1, 0, 0, 0).toDate());
		book.setTitle("Ivanhoe");
		book.setUploadDate(new DateTime(2013, 4, 15, 0, 0, 0).toDate());
		book.setUploader(user);
		testable.save(book);
		testable.refresh(user);
		List<Book> uploadedBooks = user.getUploadedBooks();
		Assert.assertFalse(uploadedBooks.isEmpty());
	}

	@Test
	@Transactional
	public void testRetrieveAllUploadedUserBooks_VIASessionFactory() {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		transaction.begin();
		User user = new User();
		user.setCreatedDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
		user.setEmail("ion@mail.ru");
		user.setName("Ion");
		user.setPassword("ion83");
		user.setSurname("Bushmaciu");
		currentSession.save(user);

		Book book = new Book();
		book.setDescription("This book is about the times when honor means a lot for the people who fought for honor and love");
		book.setNumberOfDownloads(5);
		book.setPublicaTionDate(new DateTime(1820, 5, 1, 0, 0, 0).toDate());
		book.setTitle("Ivanhoe");
		book.setUploadDate(new DateTime(2013, 4, 15, 0, 0, 0).toDate());
		book.setUploader(user);
		currentSession.save(book);
		currentSession.refresh(user);
		List<Book> uploadedBooks = user.getUploadedBooks();
		Assert.assertFalse(uploadedBooks.isEmpty());
		transaction.rollback();
	}

	@Test
	@Transactional
	public void testFindUser() {
		testCreateUser();

		User findUser = testable.findUser("ion@mail.ru", "ion83");

		Assert.assertNotNull(findUser);
	}

	@Test
	@Transactional
	public void testFindUserNotFound() {
		testCreateUser();
		User findUser = null;
		try {
			findUser = testable.findUser("ion@mail.ru", "wrong");
		} catch (ObjectsNotFoundException e) {
			Assert.assertEquals(
					"Objects were not found in the database for User entity, with given parameters: , ion@mail.ru, wrong",
					e.getMessage());
		}
		Assert.assertNull(findUser);
	}

	@Test
	@Transactional
	public void testFindUserBooks() {
		testRetrieveAllUploadedUserBooks();
		Book book = new Book();
		book.setDescription("This book is about relation between man and uman when the man is veteran of the first war");
		book.setNumberOfDownloads(5);
		book.setPublicaTionDate(new DateTime(1926, 10, 1, 0, 0, 0).toDate());
		book.setTitle("The sun also rises");
		book.setUploadDate(new DateTime(2013, 9, 17, 0, 0, 0).toDate());
		book.setUploader(user);
		testable.save(book);

		List<Book> retrieveAllUploadedUserBooks = testable
				.retrieveAllUploadedUserBooks(user);

		Assert.assertFalse(retrieveAllUploadedUserBooks.isEmpty());
		Assert.assertEquals(2, retrieveAllUploadedUserBooks.size());
	}

}
