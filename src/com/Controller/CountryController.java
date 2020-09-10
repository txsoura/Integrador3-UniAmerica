package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.CountryDao;
import com.Model.bean.Country;

public class CountryController {
	private final CountryDao countryDao = new CountryDao();

	 public List<Country> index() {
		 return countryDao.index();
	 }
	 
	    public void store(Country country) throws UnsupportedEncodingException {
	        countryDao.store(country);
	    }

	    public Country show(int id) {
	        return countryDao.show(id);
	    }


	    public void update(Country country) {
	        countryDao.update(country);
	    }

	    public void delete(Country country) {
	        countryDao.delete(country);
	    }

}
