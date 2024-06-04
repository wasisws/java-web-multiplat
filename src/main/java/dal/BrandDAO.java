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
import model.Brand;

/**
 * @author duy20
 */
public class BrandDAO extends DBPropertises {

    public List<Brand> getBrandList() {
        List<Brand> list = new ArrayList<>();
        try {
            SQL = "select * from " + brandTBL;
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                list.add(new Brand(ID, Name));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Brand> getBrandListByCategory(String categoryName) {
        List<Brand> list = new ArrayList<>();
        try {
            SQL = "select * from " + brandTBL + " b"
                    + " join " + categoryTBL + " c on b.CateID = c.ID"
                    + " where c.Name=?";
            ps = con.prepareStatement(SQL);
            CategoryDAO cateDAO = new CategoryDAO();
            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Brand(rs.getInt(1), rs.getString(2)));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductOptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Brand getBrandByName(String brandName) {
        try {
            SQL = "select * from " + brandTBL
                    + " where Name=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, brandName);
            rs = ps.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                finalize();
                return new Brand(ID, Name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrandDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
