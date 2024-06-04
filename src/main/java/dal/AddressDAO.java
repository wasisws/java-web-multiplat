/*
 * DuyDuc94
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.DBPropertises;
import model.Address;

/**
 * @author duy20
 */
public class AddressDAO extends DBPropertises {

    //Return address list of a user with userID
    public List<Address> getAddressList(int userID) {
        List<Address> list = new ArrayList<>();
        try {
            SQL = "select * from " + addressTBL
                    + " where UserID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                boolean isDefault = rs.getBoolean("IsDefault");
                list.add(new Address(ID, address, city, userID, isDefault));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Return address with addressID
    public Address getAddress(int id) {
        try {
            SQL = "select * from " + addressTBL
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String address = rs.getString("Address");
                String city = rs.getString("City");
                int userID = rs.getInt("UserID");
                boolean isDefault = rs.getBoolean("IsDefault");
                finalize();
                return new Address(id, address, city, userID, isDefault);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addAddress(String address, String city, int userID) {
        try {
            boolean haveFirstAddress = checkFirstAddress(userID);
            SQL = "insert into " + addressTBL
                    + " values(?,?,?,?)";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.setNString(2, address);
            ps.setNString(3, city);
            if (haveFirstAddress) {
                ps.setBoolean(userID, true);
            } else {
                ps.setBoolean(userID, false);
            }
            ps.executeUpdate();
            finalize();
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Check if user register new address, it will be default address
    public boolean checkFirstAddress(int userID) {
        try {
            SQL = "select * from " + addressTBL
                    + " where UserID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                finalize();
                return false;
            }
            finalize();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateAddress(int id, String address, String city) {
        try {
            SQL = "update " + addressTBL
                    + " set Address=?, City=?"
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setNString(1, address);
            ps.setNString(2, city);
            ps.setInt(3, id);
            ps.executeUpdate();
            finalize();
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean removeAddress(int id) {
        try {
            SQL = "delete from " + addressTBL
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            finalize();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean removeDefault(int oldID, int newID) {
        if (changeDefault(oldID, newID)) {
            if (removeAddress(oldID)) {
                return true;
            }
        }
        return false;
    }

    public boolean setDefault(int id) {
        try {
            SQL = "update " + addressTBL
                    + " set IsDefault=1"
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            finalize();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean removeDefault(int id) {
        try {
            SQL = "update " + addressTBL
                    + " set IsDefault=0"
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            finalize();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean changeDefault(int oldID, int newID) {
        if (removeDefault(oldID)) {
            if (setDefault(newID)) {
                return true;
            }
        }
        return false;
    }
}
