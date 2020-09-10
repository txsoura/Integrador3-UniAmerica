package com.Model.DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Connection.ConnectionFactory;
import com.Model.bean.Wallet;

public class WalletDao{
	 private Connection con = null;

	    public WalletDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<Wallet> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Wallet> wallets = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM wallets");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Wallet wallet;
	                wallet = new Wallet();
	                wallet.setId(rs.getInt("id"));
	                wallet.setBalance(rs.getDouble("balance"));
	                wallets.add(wallet);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(WalletDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return wallets;
	    }

	    public void store(Wallet wallet) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO wallets (balance) VALUES (?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setDouble(1, wallet.getBalance());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(WalletDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public List<Wallet> show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Wallet> wallets = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM wallets WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Wallet wallet = new Wallet();
	            	 wallet.setId(rs.getInt("id"));
		                wallet.setBalance(rs.getDouble("balance"));
	                wallets.add(wallet);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(WalletDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return wallets;
	    }

	    public boolean update(Wallet wallet) {
	        String sql = "UPDATE wallets SET balance=? WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setDouble(1, wallet.getBalance());
	            stmt.setInt(2, wallet.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(Wallet wallet) {
	        String sql = "DELETE FROM wallets WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, wallet.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }
}