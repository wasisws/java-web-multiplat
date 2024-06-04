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
import model.Cart_Item;

/**
 * @author duy20
 */
public class CartDAO extends DBPropertises {

    public List<Cart_Item> getCartListOf(int userID) {
        List<Cart_Item> list = new ArrayList<>();
        try {
            SQL = "select * from " + cartTBL
                    + " join " + productOptionTBL + " ProDetailID = ID"
                    + " where UserID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int proDetailID = rs.getInt("ProDetailID");
                int quantity = rs.getInt("Quantity");
                String image = rs.getString("Image");
                list.add(new Cart_Item(ID, userID, proDetailID, quantity, image));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Cart_Item getCartItem(int userID, int proDetailID) {
        try {
            SQL = "select * from " + cartTBL
                    + " join " + productOptionTBL + " ProDetailID = ID"
                    + " where UserID=? and ProDetailID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.setInt(2, proDetailID);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                int quantity = rs.getInt("Quantity");
                String image = rs.getString("Image");
                finalize();
                return new Cart_Item(ID, userID, proDetailID, quantity, image);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addToCart(int userID, int proDetailID, int quantity) {
        try {
            SQL = "insert into " + cartTBL
                    + " values(?,?,?)";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.setInt(2, proDetailID);
            ps.setInt(3, quantity);
            ps.executeUpdate();
            finalize();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateToCart(int userID, int proDetailID, int quantity) {
        try {
            SQL = "update " + cartTBL
                    + " set Quantity=?"
                    + " where UserID=? and ProDetailID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, quantity);
            ps.setInt(2, userID);
            ps.setInt(3, proDetailID);
            ps.executeUpdate();
            finalize();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int canAddMore(int userID, int proDetailID, int quantity) {
        try {
            SQL = "select ci.Quantity as 'quanInCart', pdt.Quantity as 'quanRemain'"
                    + " from " + cartTBL + " ci"
                    + " join " + productOptionTBL + " pdt on ci.ProDetailID = pdt.ID"
                    + " where ci.UserID=? and ci.ProDetailID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.setInt(2, proDetailID);
            rs = ps.executeQuery();
            if (rs.next()) {
                int quanInCart = rs.getInt("quanInCart");
                int quanRemain = rs.getInt("quanRemain");
                if ((quanRemain - quanInCart) >= quantity) {
                    finalize();
                    return quanInCart + quantity;   //New quantity
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean isInCart(int userID, int proDetailID) {
        try {
            SQL = "select * from " + cartTBL
                    + " where UserID=? and ProDetailID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.setInt(2, proDetailID);
            rs = ps.executeQuery();
            if (rs.next()) {
                finalize();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean removeAllCart(int userID) {
        try {
            SQL = "delete from " + cartTBL
                    + " where UserID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.executeUpdate();
            finalize();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Failed at remove all cart of UsedID = " + userID);
        return false;
    }

    public void removeCart(int cartID) {
        try {
            SQL = "delete from " + cartTBL
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, cartID);
            ps.executeUpdate();
            finalize();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
