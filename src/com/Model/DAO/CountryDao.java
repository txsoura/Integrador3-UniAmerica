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
import com.Model.bean.Country;

public class CountryDao{
	 private Connection con = null;

	    public CountryDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<Country> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Country> countries = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM countries");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Country country;
	                country = new Country();
	                country.setId(rs.getInt("id"));
	                country.setName(rs.getString("name"));
	                country.setCode(rs.getString("code"));

	                countries.add(country);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(CountryDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return countries;
	    }

	    public void store(Country country) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO countries (name,code) VALUES (?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, country.getName());
	            stmt.setString(2, country.getCode());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(CountryDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public Country show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Country country = new Country();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM countries WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	 country.setId(rs.getInt("id"));
	            	 country.setName(rs.getString("name"));
		                country.setCode(rs.getString("code"));
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(CountryDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return country;
	    }

	    public boolean update(Country country) {
	        String sql = "UPDATE countries SET name=?,code=? WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, country.getName());
	            stmt.setString(2, country.getCode());
	            stmt.setInt(3, country.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(Country country) {
	        String sql = "DELETE FROM countries WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, country.getId());
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
