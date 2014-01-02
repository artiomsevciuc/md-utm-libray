package md.utm.library.model.bo;

import java.util.List;

import md.utm.library.model.entity.Customer;
 
public interface CustomerBo{
	
	void addCustomer(Customer customer);
	
	List<Customer> listCustomer();
	
}