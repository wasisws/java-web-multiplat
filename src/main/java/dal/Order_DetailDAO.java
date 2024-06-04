/*
 * DuyDuc94
 */

package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.DBPropertises;
import model.Cart_Item;
import model.Order;
import model.Order_Detail;

/**
 * @author duy20
 */
public class Order_DetailDAO extends DBPropertises {

    public List<Order_Detail> getOrderDetailList(int orderID) {
        List<Order_Detail> list = new ArrayList<>();
        try {
            SQL = "select * from " + orderDetailTBL
                    + " where OrderID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int proDetailID = rs.getInt("ProDetailID");
                int quantity = rs.getInt("Quantity");
                double price = rs.getDouble("Price");
                list.add(new Order_Detail(ID, proDetailID, quantity, price, orderID));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addInOrder(int orderID, int userID) {
        CartDAO cartDAO = new CartDAO();
        List<Cart_Item> cartList = cartDAO.getCartListOf(userID);
        for (Cart_Item cartItem : cartList) {
            try {
                String SQL = "insert into " + orderDetailTBL
                        + " values(?, ?, ?, ?)";
                ps = con.prepareStatement(SQL);
                ps.setInt(1, cartItem.getProDetailID());
                ps.setInt(2, cartItem.getQuantity());
                ps.setDouble(3, cartItem.getPrice());
                ps.setInt(4, orderID);
                ps.executeUpdate();
                finalize();
            } catch (SQLException ex) {
                Logger.getLogger(Order_DetailDAO.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
        if(cartDAO.removeAllCart(userID)){
            return true;
        }
        System.out.println("Failed at add in order with orderID = " + orderID + ", userID = " + userID);
        return false;
    }
}
