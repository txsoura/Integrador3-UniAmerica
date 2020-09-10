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
import com.Model.bean.Ticket;

public class TicketDao{
	 private Connection con = null;

	    public TicketDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<Ticket> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Ticket> tickets = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM tickets");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Ticket ticket;
	                ticket = new Ticket();
	                ticket.setId(rs.getInt("id"));
	                ticket.setPrice(rs.getDouble("price"));
//	                ticket.setStatus((TicketStatus)Enum.Parse(typeof(TicketStatus)rs.getString("type"))));

	                tickets.add(ticket);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return tickets;
	    }

	    public void store(Ticket ticket) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO tickets (street,number,postcode,complement,district) VALUES (?,?,?,?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setDouble(1, ticket.getPrice());
	            stmt.setString(2, ""+ticket.getStatus());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public Ticket show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Ticket ticket = new Ticket();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM tickets WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	 ticket.setId(rs.getInt("id"));
		                ticket.setPrice(rs.getDouble("price"));
//		                ticket.setStatus((TicketStatus)Enum.Parse(typeof(TicketStatus)rs.getString("type"))));
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return ticket;
	    }

	    public boolean update(Ticket ticket) {
	        String sql = "UPDATE tickets SET street=?,number=? ,postcode=? ,complement=? ,district=?  WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setDouble(1, ticket.getPrice());
	            stmt.setString(2, ""+ticket.getStatus());
	            stmt.setInt(3, ticket.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(Ticket ticket) {
	        String sql = "DELETE FROM tickets WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, ticket.getId());
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
