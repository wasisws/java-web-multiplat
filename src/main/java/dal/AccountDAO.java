/*
 *     DuyDuc94
 */
package dal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.DBPropertises;
import model.*;

public class AccountDAO extends DBPropertises {

    //Add new user into database
    public Account addUser(String username, String password, String name, String phone, String email) {
        try {
            SQL = "insert into " + userTBL
                    + "(username, password, name, phone, email)"
                    + " values(?, ?, ?, ?, ?)";
            ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setNString(3, name);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.executeUpdate();
            finalize();
            return getUser(username, password);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Return user with correct username and password
    public Account getUser(String username, String password) {
        try {
            SQL = "Select * from " + userTBL
                    + " where username=? and password=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                boolean Role = rs.getBoolean("role");
                boolean Status = rs.getBoolean("status");
                String Name = rs.getString("name");
                String Phone = rs.getString("phone");
                String Email = rs.getString("Email");
                finalize();
                return new Account(ID, username, password, Role, Status, Name, Phone, Email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Return user with correct id
    public Account getUserByID(int ID) {
        try {
            SQL = "select * from " + userTBL
                    + " where ID = ?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String Username = rs.getString("username");
                String Password = rs.getString("password");
                boolean Role = rs.getBoolean("role");
                boolean Status = rs.getBoolean("status");
                String Name = rs.getString("name");
                String Phone = rs.getString("phone");
                String Email = rs.getString("Email");
                finalize();
                return new Account(ID, Username, Password, Role, Status, Name, Phone, Email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Check if username has exist
    public boolean checkUsernameExist(String username) {
        try {
            SQL = "select * from " + userTBL
                    + " where username = ?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                finalize();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Update user's infomation and return new user
    public Account updateUserInfomation(int id, String name, String phone, String email) {
        try {
            SQL = "update " + userTBL
                    + " set Name=?, Phone=?, Email=?"
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setNString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            ps.setInt(4, id);
            ps.executeUpdate();
            finalize();
            return getUserByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Update user's password and return new user
    public Account updateUserPassword(int id, String newPassword) {
        try {
            SQL = "update " + userTBL
                    + " set Password=?"
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, newPassword);
            ps.setInt(2, id);
            ps.executeUpdate();
            finalize();
            return getUserByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Check if user's email is exist in database
    public boolean checkEmailExist(String email) {
        try {
            SQL = "select * from " + userTBL
                    + " where email=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                finalize();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
