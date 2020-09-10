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
import com.Model.bean.User;

public class UserDao {
	 private Connection con = null;

	    public UserDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<User> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<User> users = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM users");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	User user;
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
//	                user.setRole((UserRole)Enum.Parse(typeof(UserRole),rs.getString("role")));
//	                user.setStatus((UserStatus)Enum.Parse(typeof(UserStatus),rs.getString("status")));
	                users.add(user);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return users;
	    }

	    public void store(User user) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO users (email,status,password,role) VALUES (?,?,?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, user.getEmail());
	            stmt.setString(2,  ""+user.getStatus());
	            stmt.setString(3, user.getPassword());
	            stmt.setString(4, ""+user.getRole());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public User show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        User user = new User();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM users WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	user.setId(rs.getInt("id"));
	            	 user.setEmail(rs.getString("email"));
		                user.setPassword(rs.getString("password"));
//	                user.setRole((UserRole)Enum.Parse(typeof(UserRole),rs.getString("role")));
//	                user.setStatus((UserStatus)Enum.Parse(typeof(UserStatus),rs.getString("status")));
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return user;
	    }

	    public boolean update(User user) {
	        String sql = "UPDATE users SET name=?,status=?,role=?,password=? WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, user.getEmail());
	            stmt.setString(2,  ""+user.getStatus());
	            stmt.setString(3, user.getPassword());
	            stmt.setString(4, ""+user.getRole());
	            stmt.setInt(5, user.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(User user) {
	        String sql = "DELETE FROM users WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, user.getId());
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
