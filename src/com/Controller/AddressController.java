package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.AddressDao;
import com.Model.bean.Address;

public class AddressController {
	private final AddressDao addressDao = new AddressDao();

	 public List<Address> index() {
		 return addressDao.index();
	 }
	 
	    public void store(Address address) throws UnsupportedEncodingException {
	        addressDao.store(address);
	    }

	    public Address show(int id) {
	        return addressDao.show(id);
	    }


	    public void update(Address address) {
	        addressDao.update(address);
	    }

	    public void delete(Address address) {
	        addressDao.delete(address);
	    }

}
