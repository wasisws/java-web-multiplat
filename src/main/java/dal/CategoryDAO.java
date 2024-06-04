/*
 *     DuyDuc94
 */
package dal;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.DBPropertises;
import model.*;

public class CategoryDAO extends DBPropertises {

    public List<Category> getCategoryList() {
        List<Category> list = new ArrayList<>();
        try {
            SQL = "select * from " + categoryTBL;
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                list.add(new Category(ID, Name));
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
