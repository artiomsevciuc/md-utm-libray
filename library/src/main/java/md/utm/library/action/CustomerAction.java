package md.utm.library.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import md.utm.library.bo.CustomerBo;
import md.utm.library.entity.Customer;

import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction implements ModelDriven<Customer> {

	Customer customer = new Customer();
	List<Customer> customerList = new ArrayList<Customer>();

	CustomerBo customerBo;

	// DI via Spring
	public void setCustomerBo(CustomerBo customerBo) {
		this.customerBo = customerBo;
	}

	public Customer getModel() {
		return customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	// save customer
	public String addCustomer() throws Exception {

		// save it
		customer.setCreatedDate(new Date());
		customerBo.addCustomer(customer);
		if (customer.getName() != null) {
			// reload the customer list
			customerList = null;
			customerList = customerBo.listCustomer();

			return "success";
		}
		return "error";
	}

	// list all customers
	public String listCustomer() throws Exception {

		customerList = customerBo.listCustomer();

		return "success";

	}

}