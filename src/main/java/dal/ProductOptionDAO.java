/*
 *     DuyDuc94
 */

package dal;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.DBPropertises;
import model.Product_Detail;

public class ProductOptionDAO extends DBPropertises {
    
    public List<Product_Detail> getProductOptList() {
        List<Product_Detail> list = new ArrayList<>();
        try {
            SQL = "select * from " + productOptionTBL;
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int ProID = rs.getInt("ProID");
                int Quantity = rs.getInt("Quantity");
                double Price = rs.getDouble("Price");
                String Image = rs.getString("Image");
                String Color = rs.getString("Color");
                list.add(new Product_Detail(ID, ProID, Quantity, Price, Image, Color));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Product_Detail> getProductOptList(int ProID) {
        List<Product_Detail> list = new ArrayList<>();
        try {
            SQL = "select * from "+ productOptionTBL
                    + " where ProID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, ProID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int Quantity = rs.getInt("Quantity");
                double Price = rs.getDouble("Price");
                String Image = rs.getString("Image");
                String Color = rs.getString("Color");
                list.add(new Product_Detail(ID, ProID, Quantity, Price, Image, Color));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Product_Detail getProductOpt(int proDetailID) {
        try {
            SQL = "select * from "+ productOptionTBL
                    + " where ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, proDetailID);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ProID = rs.getInt("ProID");
                int Quantity = rs.getInt("Quantity");
                double Price = rs.getDouble("Price");
                String Image = rs.getString("Image");
                String Color = rs.getString("Color");
                finalize();
                return new Product_Detail(proDetailID, ProID, Quantity, Price, Image, Color);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Product_Detail getColor(int ProID, String color) {
        try {
            SQL = "select * from "+ productOptionTBL +""
                    + " where ProID=? and Color=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, ProID);
            ps.setString(2, color);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                int Quantity = rs.getInt("Quantity");
                double Price = rs.getDouble("Price");
                String Image = rs.getString("Image");
                String Color = rs.getString("Color");
                finalize();
                return new Product_Detail(ID, ProID, Quantity, Price, Image, Color);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getName(int proDetailID) {
        try {
            SQL = "select p.Name from "+ productOptionTBL +" pdt"
                    + " join Product p on pdt.ProID = p.ID"
                    + " where pdt.ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, proDetailID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("Name");
                finalize();
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Unknown";
    }

    //Get list price of all option of a productTBL
    public List<Double> getPrices(int ProID) {
        List<Double> list = new ArrayList<>();
        try {
            SQL = "select Price from "+ productOptionTBL
                    + " where ProID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, ProID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getDouble("Price"));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
