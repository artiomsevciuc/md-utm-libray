package md.utm.strutsspringhibernate.dao;

import java.util.List;

import md.utm.strutsspringhibernate.model.Customer;

public interface CustomerDAO {

	void addCustomer(Customer customer);

	List<Customer> listCustomer();

	List<Customer> loginCustomer(Customer customer);

}