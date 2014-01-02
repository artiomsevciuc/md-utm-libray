package md.utm.library.bo;

import java.util.List;

import md.utm.library.entity.Customer;
 
public interface CustomerBo{
	
	void addCustomer(Customer customer);
	
	List<Customer> listCustomer();
	
}