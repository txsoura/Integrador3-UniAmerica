package com.Model.DAO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Connection.ConnectionFactory;
import com.Enum.EventType;
import com.Model.bean.Event;

public class EventDao{
	 private Connection con = null;

	    public EventDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<Event> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Event> events = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM events");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Event event;
	                event = new Event();
	                event.setId(rs.getInt("id"));
	                event.setName(rs.getString("name"));
	                event.setDescription(rs.getString("description"));
	                event.setStart(rs.getDate("start"));
	                event.setEnd(rs.getDate("end"));
	                event.setPrice(rs.getDouble("price"));
	                event.setPromo_price(rs.getDouble("promo_price"));
//	                event.setType((EventType)Enum.Parse(typeof(EventType)rs.getString("type"))));

	                events.add(event);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return events;
	    }

	    public void store(Event event) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO events (street,number,postcode,complement,district) VALUES (?,?,?,?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, event.getName());
	            stmt.setString(2, event.getDescription());
	            stmt.setDate(3,(Date) event.getStart());
	            stmt.setDate(4,(Date) event.getEnd());
	            stmt.setDouble(5, event.getPrice());
	            stmt.setDouble(6, event.getPromo_price());
	            stmt.setString(7, ""+event.getType());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public Event show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Event event = new Event();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM events WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	 event.setId(rs.getInt("id"));
	            	 event.setName(rs.getString("name"));
		                event.setDescription(rs.getString("description"));
		                event.setStart(rs.getDate("start"));
		                event.setEnd(rs.getDate("end"));
		                event.setPrice(rs.getDouble("price"));
		                event.setPromo_price(rs.getDouble("promo_price"));
//		                event.setType((EventType)Enum.Parse(typeof(EventType)rs.getString("type"))));
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return event;
	    }

	    public boolean update(Event event) {
	        String sql = "UPDATE events SET street=?,number=? ,postcode=? ,complement=? ,district=?  WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, event.getName());
	            stmt.setString(2, event.getDescription());
	            stmt.setDate(3,(Date) event.getStart());
	            stmt.setDate(4,(Date) event.getEnd());
	            stmt.setDouble(5, event.getPrice());
	            stmt.setDouble(6, event.getPromo_price());
	            stmt.setString(7, ""+event.getType());
	            stmt.setInt(8, event.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(Event event) {
	        String sql = "DELETE FROM events WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, event.getId());
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
