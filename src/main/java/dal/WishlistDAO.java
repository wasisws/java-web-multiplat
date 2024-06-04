/*
 *     DuyDuc94
 */

package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.DBPropertises;
import model.Product;

public class WishlistDAO extends DBPropertises {

    public List<Product> getWishlistOf(int UserID) {
        List<Product> list = new ArrayList<>();
        ProductDAO proDAO = new ProductDAO();
        try {
            SQL = "select * from " + wishlistTBL
                    + " where UserID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, UserID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ProID = rs.getInt("ProID");
                list.add(proDAO.getProductByID(ProID));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //True if add to wishlistTBL success
    public boolean addToWishlist(int userID, int proID) {
        try {
            //Check if wishlistTBL is exist
            SQL = "select * from " + wishlistTBL
                    + " where UserID=? and ProID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.setInt(2, proID);
            rs = ps.executeQuery();
            if (rs.next()) {
                finalize();
                return false;
            } else {
                //Add wishlistTBL to database
                String xSQL = "insert into Wishlist values(?, ?)";
                ps = con.prepareStatement(xSQL);
                ps.setInt(1, userID);
                ps.setInt(2, proID);
                ps.executeUpdate();
                finalize();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void removeWishlist(int userID, int proID) {
        try {
            SQL = "delete from " + wishlistTBL
                    + " where UserID=? and ProID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ps.setInt(2, proID);
            ps.executeUpdate();
            finalize();
        } catch (SQLException ex) {
            Logger.getLogger(WishlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
