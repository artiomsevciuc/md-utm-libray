package md.utm.strutsspringhibernate.dao.impl;

import java.util.List;

import md.utm.strutsspringhibernate.dao.CustomerDAO;
import md.utm.strutsspringhibernate.model.Customer;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO {

	// add the customer
	public void addCustomer(Customer customer) {
		getHibernateTemplate().save(customer);
	}

	// return all the customers in list
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomer() {
		return getHibernateTemplate().find("from Customer");
	}

	// return all the customers in list
	@SuppressWarnings("unchecked")
	public List<Customer> loginCustomer(Customer customer) {
		return getHibernateTemplate().find(
				"from Customer where name=? and password=?",
				customer.getName(), customer.getPassword());
	}

}