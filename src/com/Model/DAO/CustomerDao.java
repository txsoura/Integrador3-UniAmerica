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
import com.Model.bean.Customer;

public class CustomerDao{

    private Connection con = null;

    public CustomerDao() {
        con = ConnectionFactory.getConnection();
    }

    public List<Customer> index() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Customer> customers = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM customers");
            rs = stmt.executeQuery();

            while (rs.next()) {
            	Customer customer;
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setCellphone(rs.getInt("cellphone"));
                customer.setBirthdate(rs.getDate("birthdate"));
//                customer.setSex((UserSex)Enum.Parse(typeof(UserSex),rs.getString("sex")));
                customers.add(customer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeconnection(con, stmt, rs);
        }
        return customers;
    }

    public void store(Customer customer) throws UnsupportedEncodingException {
        String sql = "INSERT INTO customers (name,sex,birthdate,cellphone) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2,  ""+customer.getSex());
            stmt.setDate(3, (Date)customer.getBirthdate());
            stmt.setInt(4, customer.getCellphone());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Customer> show(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Customer> customers = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM customers WHERE id LIKE ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
            	Customer customer = new Customer();
            	customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setCellphone(rs.getInt("cellphone"));
                customer.setBirthdate(rs.getDate("birthdate"));
//                customer.setSex((UserSex)Enum.Parse(typeof(UserSex),rs.getString("sex")));
                customers.add(customer);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeconnection(con, stmt, rs);
        }
        return customers;
    }

    public boolean update(Customer customer) {
        String sql = "UPDATE customers SET name=?,sex=?,birthdate=?,cellphone=? WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2,  ""+customer.getSex());
            stmt.setDate(3, (Date)customer.getBirthdate());
            stmt.setInt(4, customer.getCellphone());
            stmt.setInt(5, customer.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            ConnectionFactory.closeconnection(con, stmt);
        }
    }

    public boolean delete(Customer customer) {
        String sql = "DELETE FROM customers WHERE id=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, customer.getId());
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