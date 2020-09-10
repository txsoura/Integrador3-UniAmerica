package com.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.Model.DAO.WalletDao;
import com.Model.bean.Wallet;

public class WalletController {
	private final WalletDao walletDao = new WalletDao();

	 public List<Wallet> index() {
		 return walletDao.index();
	 }
	 
	    public void store(Wallet wallet) throws UnsupportedEncodingException {
	        walletDao.store(wallet);
	    }

	    public Wallet show(int id) {
	        return walletDao.show(id);
	    }


	    public void update(Wallet wallet) {
	        walletDao.update(wallet);
	    }

	    public void delete(Wallet wallet) {
	        walletDao.delete(wallet);
	    }

}
