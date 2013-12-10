package md.utm.strutsspringhibernate.dao.impl;

import java.util.List;

import md.utm.strutsspringhibernate.dao.UserDAO;
import md.utm.strutsspringhibernate.model.Books;
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
	private UserDAO userDAO;
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
		userDAO.save(user);
		Assert.assertTrue(user.getId() > 0);
	}

	@Test
	@Transactional
	public void testUpdateUser() {
		testCreateUser();
		User foundUser = userDAO.get(User.class, user.getId());
		Assert.assertNotNull(foundUser);
		foundUser.setName("Andrei");
		userDAO.saveOrUpdate(foundUser);
		foundUser = userDAO.get(User.class, user.getId());
		Assert.assertNotNull(foundUser);
		Assert.assertEquals("Andrei", foundUser.getName());
	}

	@Test
	@Transactional
	public void testRetrieveAllUploadedUserBooks() {
		testCreateUser();
		Books book = new Books();
		book.setDescription("This book is about the times when honor means a lot for the people who fought for honor and love");
		book.setNumberOfDownloads(5);
		book.setPublicaTionDate(new DateTime(1820, 5, 1, 0, 0, 0).toDate());
		book.setTitle("Ivanhoe");
		book.setUploadDate(new DateTime(2013, 4, 15, 0, 0, 0).toDate());
		book.setUploader(user);
		userDAO.save(book);
		userDAO.refresh(user);
		List<Books> uploadedBooks = user.getUploadedBooks();
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

		Books book = new Books();
		book.setDescription("This book is about the times when honor means a lot for the people who fought for honor and love");
		book.setNumberOfDownloads(5);
		book.setPublicaTionDate(new DateTime(1820, 5, 1, 0, 0, 0).toDate());
		book.setTitle("Ivanhoe");
		book.setUploadDate(new DateTime(2013, 4, 15, 0, 0, 0).toDate());
		book.setUploader(user);
		currentSession.save(book);
		currentSession.refresh(user);
		List<Books> uploadedBooks = user.getUploadedBooks();
		Assert.assertFalse(uploadedBooks.isEmpty());
		transaction.rollback();
	}

}
