package md.utm.library.bo;

import java.util.List;

import md.utm.library.model.Customer;
 
public interface CustomerBo{
	
	void addCustomer(Customer customer);
	
	List<Customer> listCustomer();
	
}