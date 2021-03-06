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
import com.Model.bean.Address;

public class AddressDao {
	private Connection con = null;

	public AddressDao() {
		con = ConnectionFactory.getConnection();
	}

	public List<Address> index() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Address> addresses = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM addresses");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Address address = new Address();
				address.setId(rs.getInt("id"));
				address.setStreet(rs.getString("street"));
				address.setNumber(rs.getInt("number"));
				address.setPostcode(rs.getInt("postcode"));
				address.setComplement(rs.getString("complement"));
				address.setDistrict(rs.getString("district"));

				addresses.add(address);
			}

		} catch (SQLException ex) {
			Logger.getLogger(AddressDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeconnection(con, stmt, rs);
		}
		return addresses;
	}

	public boolean store(Address address) throws Exception {
		String sql = "INSERT INTO addresses (street,number,postcode,complement,district) VALUES (?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, address.getStreet());
			stmt.setInt(2, address.getNumber());
			stmt.setInt(3, address.getPostcode());
			stmt.setString(4, address.getComplement());
			stmt.setString(5, address.getDistrict());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.err.println("Erro" + ex);
			return false;
		} finally {
			ConnectionFactory.closeconnection(con, stmt);
		}

	}

	public List<Address> show(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Address> addresses = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT * FROM addresses WHERE id= ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Address address = new Address();
				address.setId(rs.getInt("id"));
				address.setStreet(rs.getString("street"));
				address.setNumber(rs.getInt("number"));
				address.setPostcode(rs.getInt("postcode"));
				address.setComplement(rs.getString("complement"));
				address.setDistrict(rs.getString("district"));
				addresses.add(address);
			}

		} catch (SQLException ex) {
			Logger.getLogger(AddressDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeconnection(con, stmt, rs);
		}
		return addresses;
	}

	public boolean update(Address address) throws UnsupportedEncodingException {
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE addresses SET street=?,number=? ,postcode=? ,complement=? ,district=?  WHERE id=?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, address.getStreet());
			stmt.setInt(2, address.getNumber());
			stmt.setInt(3, address.getPostcode());
			stmt.setString(4, address.getComplement());
			stmt.setString(5, address.getDistrict());
			stmt.setInt(6, address.getId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.err.println("Erro" + ex);
			return false;
		} finally {
			ConnectionFactory.closeconnection(con, stmt);
		}
	}

	public boolean delete(int id) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM addresses WHERE id=?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
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
