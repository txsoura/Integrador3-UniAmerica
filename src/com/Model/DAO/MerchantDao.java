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
import com.Model.bean.Merchant;

public class MerchantDao {
	 private Connection con = null;

	    public MerchantDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<Merchant> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Merchant> merchants = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM merchants");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Merchant merchant;
	                merchant = new Merchant();
	                merchant.setName(rs.getString("name"));
	                merchant.setCellphone(rs.getInt("cellphone"));
	                merchant.setCpf_cnpj(rs.getInt("cpf_cnpj"));
	                merchants.add(merchant);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(MerchantDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return merchants;
	    }

	    public void store(Merchant merchant) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO merchants (name,cpf_cnpj,cellphone) VALUES (?,?,?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, merchant.getName());
	            stmt.setInt(2, merchant.getCpf_cnpj());
	            stmt.setInt(3, merchant.getCellphone());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(MerchantDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public List<Merchant> show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Merchant> merchants = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM merchants WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Merchant merchant = new Merchant();
	                merchant.setName(rs.getString("name"));
	                merchant.setCellphone(rs.getInt("cellphone"));
	                merchant.setCpf_cnpj(rs.getInt("cpf_cnpj"));
	                merchants.add(merchant);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(MerchantDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return merchants;
	    }

	    public boolean update(Merchant merchant) {
	        String sql = "UPDATE merchants SET name=?,cpf_cnpj=?,cellphone=? WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, merchant.getName());
	            stmt.setInt(2, merchant.getCpf_cnpj());
	            stmt.setInt(3, merchant.getCellphone());
	            stmt.setInt(4, merchant.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(Merchant merchant) {
	        String sql = "DELETE FROM merchants WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, merchant.getId());
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