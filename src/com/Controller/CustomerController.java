package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.CustomerDao;
import com.Model.bean.Customer;

public class CustomerController {
	private final CustomerDao customerDao = new CustomerDao();

	 public List<Customer> index() {
		 return customerDao.index();
	 }
	 
	    public void store(Customer customer) throws UnsupportedEncodingException {
	        customerDao.store(customer);
	    }

	    public Customer show(int id) {
	        return customerDao.show(id);
	    }


	    public void update(Customer customer) {
	        customerDao.update(customer);
	    }

	    public void delete(Customer customer) {
	        customerDao.delete(customer);
	    }

}
