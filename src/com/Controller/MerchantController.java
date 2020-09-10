package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.MerchantDao;
import com.Model.bean.Merchant;

public class MerchantController {
	private final MerchantDao merchantDao = new MerchantDao();

	 public List<Merchant> index() {
		 return merchantDao.index();
	 }
	 
	    public void store(Merchant merchant) throws UnsupportedEncodingException {
	        merchantDao.store(merchant);
	    }

	    public Merchant show(int id) {
	        return merchantDao.show(id);
	    }


	    public void update(Merchant merchant) {
	        merchantDao.update(merchant);
	    }

	    public void delete(Merchant merchant) {
	        merchantDao.delete(merchant);
	    }

}
