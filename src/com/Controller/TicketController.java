package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.TicketDao;
import com.Model.bean.Ticket;

public class TicketController {
	private final TicketDao ticketDao = new TicketDao();

	 public List<Ticket> index() {
		 return ticketDao.index();
	 }
	 
	    public void store(Ticket ticket) throws UnsupportedEncodingException {
	        ticketDao.store(ticket);
	    }

	    public Ticket show(int id) {
	        return ticketDao.show(id);
	    }


	    public void update(Ticket ticket) {
	        ticketDao.update(ticket);
	    }

	    public void delete(Ticket ticket) {
	        ticketDao.delete(ticket);
	    }

}
