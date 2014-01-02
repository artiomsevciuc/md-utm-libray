package md.utm.library.bo.impl;

import java.util.List;

import md.utm.library.bo.CustomerBo;
import md.utm.library.dao.CustomerDAO;
import md.utm.library.model.Customer;

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