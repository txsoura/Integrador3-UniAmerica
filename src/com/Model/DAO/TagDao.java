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
import com.Model.bean.Tag;

public class TagDao{
	 private Connection con = null;

	    public TagDao() {
	        con = ConnectionFactory.getConnection();
	    }

	    public List<Tag> index() {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Tag> tags = new ArrayList<>();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM tags");
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	Tag tag;
	                tag = new Tag();
	                tag.setId(rs.getInt("id"));
	                tag.setName(rs.getString("name"));

	                tags.add(tag);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return tags;
	    }

	    public void store(Tag tag) throws UnsupportedEncodingException {
	        String sql = "INSERT INTO tags (name) VALUES (?,?)";
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, tag.getName());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public Tag show(int id) {
	        Connection con = ConnectionFactory.getConnection();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        Tag tag = new Tag();
	        try {
	            stmt = con.prepareStatement("SELECT * FROM tags WHERE id LIKE ?");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	            	 tag.setId(rs.getInt("id"));
	            	 tag.setName(rs.getString("name"));
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(TagDao.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt, rs);
	        }
	        return tag;
	    }

	    public boolean update(Tag tag) {
	        String sql = "UPDATE tags SET name=? WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, tag.getName());
	            stmt.setInt(2, tag.getId());
	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException ex) {
	            System.err.println("Erro" + ex);
	            return false;
	        } finally {
	            ConnectionFactory.closeconnection(con, stmt);
	        }
	    }

	    public boolean delete(Tag tag) {
	        String sql = "DELETE FROM tags WHERE id=?";
	        PreparedStatement stmt = null;

	        try {
	            stmt = con.prepareStatement(sql);
	            stmt.setInt(1, tag.getId());
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
