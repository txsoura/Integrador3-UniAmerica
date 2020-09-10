package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.EventDao;
import com.Model.bean.Event;

public class EventController {
	private final EventDao eventDao = new EventDao();

	 public List<Event> index() {
		 return eventDao.index();
	 }
	 
	    public void store(Event event) throws UnsupportedEncodingException {
	        eventDao.store(event);
	    }

	    public Event show(int id) {
	        return eventDao.show(id);
	    }


	    public void update(Event event) {
	        eventDao.update(event);
	    }

	    public void delete(Event event) {
	        eventDao.delete(event);
	    }

}
