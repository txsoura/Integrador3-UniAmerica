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
import com.Model.bean.City;

public class CityDao{
	 private Connection con = null;

	    public CityDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<City> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<City> cities = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM cities");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	City city;
	                city = new City();
	                city.setId(rs.getInt("id"));
	                city.setName(rs.getString("name"));
	                city.setCode(rs.getString("code"));

	                cities.add(city);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return cities;
	    }

	    public void store(City city) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO cities (name,code) VALUES (?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, city.getName());
	            stmt.setString(2, city.getCode());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public City show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        City city = new City();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM cities WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	 city.setId(rs.getInt("id"));
	            	 city.setName(rs.getString("name"));
		                city.setCode(rs.getString("code"));
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return city;
	    }

	    public boolean update(City city) {
	        String sql = "UPDATE cities SET name=?,code=? WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, city.getName());
	            stmt.setString(2, city.getCode());
	            stmt.setInt(3, city.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(City city) {
	        String sql = "DELETE FROM cities WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, city.getId());
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
