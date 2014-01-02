package md.utm.library.model.dao;

import java.util.List;

import md.utm.library.model.entity.Customer;

public interface CustomerDAO {

	void addCustomer(Customer customer);

	List<Customer> listCustomer();

	List<Customer> loginCustomer(Customer customer);

}