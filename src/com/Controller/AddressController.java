package com.Controller;

import java.util.ArrayList;
import java.util.List;
import com.Model.DAO.AddressDao;
import com.Model.bean.Address;

public class AddressController {
	private final AddressDao addressDao = new AddressDao();

	public void index() throws Exception {
		List<Address> addresses = new ArrayList<>();

		addresses = addressDao.index();

		for (Address address : addresses) {
			System.out.println(address.toString());
		}
	}

	public void store(Address address) throws Exception {
		addressDao.store(address);
	}

	public void show(int id) throws Exception {
		List<Address> address = new ArrayList<>();
		address = addressDao.show(id);
		System.out.println(address.toString());
	}

	public void update(Address address) throws Exception {
		addressDao.update(address);
	}

	public void delete(int id) throws Exception {
		if(addressDao.delete(id)) {
			System.out.println("Address deleted!");
		}else {
			System.out.println("Address not deleted!");
		}
	}

}
