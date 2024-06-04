/*
 * DuyDuc94
 */
package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author duy20
 */
public class DBPropertises {

    public Connection con = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    public String SQL = null;
    public String addressTBL = "[Address]";
    public String brandTBL = "[Brand]";
    public String categoryTBL = "[Category]";
    public String wishlistTBL = "[Wishlist]";
    public String cartTBL = "[Cart]";
    public String userTBL = "[User]";
    public String productTBL = "[Product]";
    public String productOptionTBL = "[Product_Option]";
    public String orderTBL = "[Order]";
    public String orderDetailTBL = "[Order_Detail]";
    public String orderStatusTBL = "[Order_Status]";

    public DBPropertises() {
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "sa";
            String server = "127.0.0.1";
            String port = "";
            String DBname = "Online_Shopping_DB";
            String url = "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + DBname;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBPropertises.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void finalize() {
        try {
            if (con != null) {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
