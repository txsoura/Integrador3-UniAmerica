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
import com.Model.bean.State;

public class StateDao{
	 private Connection con = null;

	    public StateDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<State> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<State> states = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM states");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	State State;
	                State = new State();
	                State.setId(rs.getInt("id"));
	                State.setName(rs.getString("name"));
	                State.setCode(rs.getString("code"));

	                states.add(State);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(StateDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return states;
	    }

	    public void store(State State) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO states (name,code) VALUES (?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, State.getName());
	            stmt.setString(2, State.getCode());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(StateDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public State show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        State State = new State();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM states WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	 State.setId(rs.getInt("id"));
	            	 State.setName(rs.getString("name"));
		                State.setCode(rs.getString("code"));
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(StateDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return State;
	    }

	    public boolean update(State State) {
	        String sql = "UPDATE states SET name=?,code=? WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, State.getName());
	            stmt.setString(2, State.getCode());
	            stmt.setInt(3, State.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(State State) {
	        String sql = "DELETE FROM states WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, State.getId());
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
