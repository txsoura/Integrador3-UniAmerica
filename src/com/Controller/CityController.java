package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.CityDao;
import com.Model.bean.City;

public class CityController {
	private final CityDao cityDao = new CityDao();

	 public List<City> index() {
		 return cityDao.index();
	 }
	 
	    public void store(City city) throws UnsupportedEncodingException {
	        cityDao.store(city);
	    }

	    public City show(int id) {
	        return cityDao.show(id);
	    }


	    public void update(City city) {
	        cityDao.update(city);
	    }

	    public void delete(City city) {
	        cityDao.delete(city);
	    }

}
