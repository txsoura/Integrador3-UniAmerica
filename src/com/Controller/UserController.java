package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.UserDao;
import com.Model.bean.User;

public class UserController {
	 private final UserDao userDao = new UserDao();

	 public List<User> index() {
		 return userDao.index();
	 }
	 
	    public void store(User user) throws UnsupportedEncodingException {
	        userDao.store(user);
	    }

	    public User show(int id) {
	        return userDao.show(id);
	    }


	    public void update(User user) {
	        userDao.update(user);
	    }

	    public void delete(User user) {
	        userDao.delete(user);
	    }

}
