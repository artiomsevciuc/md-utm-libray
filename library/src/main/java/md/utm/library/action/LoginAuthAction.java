package md.utm.library.action;

import java.util.List;

import md.utm.library.model.entity.Customer;
import md.utm.library.model.library.dao.CustomerDAO;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAuthAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	private CustomerDAO customerDAO;

	private Boolean error;

	@Override
	public String execute() {
		if (userId.equals("")) {
			addActionError("Please Enter user id.");
			error = true;
		} else if (password.equals("")) {
			addActionError("Please Enter password.");
			error = true;
		} else if (userId.equalsIgnoreCase(password)) {
			addActionError("Invalid userid or password.");
			error = true;
		} else if (findCustomer() == null) {
			error = true;
		} else {
			error = false;
		}

		if (error) {
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	private Object findCustomer() {
		Customer customer = new Customer();
		customer.setName(getUserId());
		customer.setPassword(getPassword());
		List<Customer> customers = getCustomerDAO().loginCustomer(customer);
		if (customers.isEmpty())
			return null;
		return customers.iterator().next();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
