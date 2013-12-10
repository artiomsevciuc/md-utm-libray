package md.utm.strutsspringhibernate.bo;

import java.util.List;

import md.utm.strutsspringhibernate.model.Customer;
 
public interface CustomerBo{
	
	void addCustomer(Customer customer);
	
	List<Customer> listCustomer();
	
}