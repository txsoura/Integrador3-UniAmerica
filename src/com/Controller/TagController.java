package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.TagDao;
import com.Model.bean.Tag;

public class TagController {
	private final TagDao tagDao = new TagDao();

	 public List<Tag> index() {
		 return tagDao.index();
	 }
	 
	    public void store(Tag tag) throws UnsupportedEncodingException {
	        tagDao.store(tag);
	    }

	    public Tag show(int id) {
	        return tagDao.show(id);
	    }


	    public void update(Tag tag) {
	        tagDao.update(tag);
	    }

	    public void delete(Tag tag) {
	        tagDao.delete(tag);
	    }

}
