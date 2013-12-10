package md.utm.strutsspringhibernate.bo.impl;

import java.util.List;

import md.utm.strutsspringhibernate.bo.CustomerBo;
import md.utm.strutsspringhibernate.dao.CustomerDAO;
import md.utm.strutsspringhibernate.model.Customer;

public class CustomerBoImpl implements CustomerBo {

	CustomerDAO customerDAO;

	// DI via Spring
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	// call DAO to save customer
	public void addCustomer(Customer customer) {

		customerDAO.addCustomer(customer);

	}

	// call DAO to return customers
	public List<Customer> listCustomer() {

		return customerDAO.listCustomer();

	}

}