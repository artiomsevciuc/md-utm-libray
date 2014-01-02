package md.utm.library.dao;

import java.util.List;

import md.utm.library.model.Customer;

public interface CustomerDAO {

	void addCustomer(Customer customer);

	List<Customer> listCustomer();

	List<Customer> loginCustomer(Customer customer);

}