package md.utm.library.model.bo.impl;

import java.util.List;

import md.utm.library.model.bo.CustomerBo;
import md.utm.library.model.entity.Customer;
import md.utm.library.model.library.dao.CustomerDAO;

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