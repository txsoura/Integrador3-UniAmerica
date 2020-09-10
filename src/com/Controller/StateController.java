package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.StateDao;
import com.Model.bean.State;

public class StateController {
	private final StateDao stateDao = new StateDao();

	 public List<State> index() {
		 return stateDao.index();
	 }
	 
	    public void store(State state) throws UnsupportedEncodingException {
	        stateDao.store(state);
	    }

	    public State show(int id) {
	        return stateDao.show(id);
	    }


	    public void update(State state) {
	        stateDao.update(state);
	    }

	    public void delete(State state) {
	        stateDao.delete(state);
	    }

}
