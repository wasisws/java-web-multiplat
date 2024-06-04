/*
 *     DuyDuc94
 */
package dal;

import java.sql.SQLException;
import java.util.*;
import lib.DBPropertises;
import model.*;

public class ProductDAO extends DBPropertises {

    //Get all productTBL
    public List<Product> getProductList() {
        List<Product> list = new ArrayList<>();
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ID"),
                        rs.getInt("BrandID"),
                        rs.getInt("CateID"),
                        rs.getString("BrandName"),
                        rs.getString("CateName"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        calculatePrice(rs.getInt("ID")),
                        rs.getInt("Sold"))
                );
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.getAllProducts(): " + ex);
        }
        return null;
    }

    //Get list products from search bar with all categories
    public List<Product> getProductList(String info) {
        List<Product> list = new ArrayList<>();
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where p.[Name] like ?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, "%" + info + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ID"),
                        rs.getInt("BrandID"),
                        rs.getInt("CateID"),
                        rs.getString("BrandName"),
                        rs.getString("CateName"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        calculatePrice(rs.getInt("ID")),
                        rs.getInt("Sold"))
                );
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.searchProducts(): " + ex);
        }
        return null;
    }

    //Get list products from search bar in selected categories
    public List<Product> getProductInCategory(String cateName, String info) {
        List<Product> list = new ArrayList<>();
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where p.Name like ? and c.Name=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, "%" + info + "%");
            ps.setString(2, cateName);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ID"),
                        rs.getInt("BrandID"),
                        rs.getInt("CateID"),
                        rs.getString("BrandName"),
                        rs.getString("CateName"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        calculatePrice(rs.getInt("ID")),
                        rs.getInt("Sold"))
                );
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.searchProductsInCategory(): " + ex);
        }
        return null;
    }

    //Get all productTBL of selected Brand
    public List<Product> getProductOfBrand(String brandName) {
        List<Product> list = new ArrayList<>();
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where b.Name=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, brandName);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ID"),
                        rs.getInt("BrandID"),
                        rs.getInt("CateID"),
                        rs.getString("BrandName"),
                        rs.getString("CateName"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        calculatePrice(rs.getInt("ID")),
                        rs.getInt("Sold"))
                );
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.getAllProductsOfBrand(): " + ex);
        }
        return null;
    }

    //Get all productTBL of selected Category
    public List<Product> getProductInCategory(String categoryName) {
        List<Product> list = new ArrayList<>();
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where c.Name=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ID"),
                        rs.getInt("BrandID"),
                        rs.getInt("CateID"),
                        rs.getString("BrandName"),
                        rs.getString("CateName"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        calculatePrice(rs.getInt("ID")),
                        rs.getInt("Sold"))
                );
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.getAllProductsInCategory(): " + ex);
        }
        return null;
    }

    //Get productTBL with its ID
    public Product getProductByID(int ID) {
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where p.ID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String Name = rs.getString("Name");
                int CateID = rs.getInt("CateID");
                int BrandID = rs.getInt("BrandID");
                String brandName = rs.getString("BrandName");
                String cateName = rs.getString("CateName");
                String Description = rs.getString("Description");
                String Image = rs.getString("Image");
                String Price = calculatePrice(ID);
                int Sold = rs.getInt("Sold");
                finalize();
                return new Product(ID, BrandID, CateID, brandName, cateName, Name, Description, Image, Price, Sold);
            }
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.getProductsByID(): " + ex);
        }
        return null;
    }

    //Get list of productTBL in same brandTBL
    public List<Product> getRelatedProductList(int brandID) {
        List<Product> list = new ArrayList<>();
        int numberRelated = 4;
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where p.BrandID=?";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, brandID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ID"),
                        rs.getInt("BrandID"),
                        rs.getInt("CateID"),
                        rs.getString("BrandName"),
                        rs.getString("CateName"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        calculatePrice(rs.getInt("ID")),
                        rs.getInt("Sold"))
                );
                if (list.size() == numberRelated) {
                    break;
                }
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.getRelatedProducts(): " + ex);
        }
        return null;
    }

    public List<Product> getProductList(String categoryName, String brandName) {
        List<Product> list = new ArrayList<>();
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where c.Name=? and b.Name=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, categoryName);
            ps.setString(2, brandName);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("ID"),
                        rs.getInt("BrandID"),
                        rs.getInt("CateID"),
                        rs.getString("BrandName"),
                        rs.getString("CateName"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        calculatePrice(rs.getInt("ID")),
                        rs.getInt("Sold"))
                );
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.getListProductsOfBrandInCategory(): " + ex);
        }
        return null;
    }

    //Get list of best sell productTBL (sold > soldValue)
    public List<Product> getBestSellProducts(String categoryName) {
        List<Product> list = new ArrayList<>();
        int soldValue = 10;
        try {
            SQL = "select p.ID, p.CateID, p.BrandID, p.[Name], p.[Description],"
                    + "p.[Image], p.[Sold], b.[Name] as 'BrandName', c.[Name] as 'CateName'"
                    + " from " + productTBL + " p"
                    + " join " + brandTBL + " b on p.BrandID = b.ID"
                    + " join " + categoryTBL + " c on p.CateID = c.ID"
                    + " where c.Name=?";
            ps = con.prepareStatement(SQL);
            ps.setString(1, categoryName);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("Sold") > soldValue) {
                    list.add(new Product(rs.getInt("ID"),
                            rs.getInt("BrandID"),
                            rs.getInt("CateID"),
                            rs.getString("BrandName"),
                            rs.getString("CateName"),
                            rs.getString("Name"),
                            rs.getString("Description"),
                            rs.getString("Image"),
                            calculatePrice(rs.getInt("ID")),
                            rs.getInt("Sold"))
                    );
                }
            }
            finalize();
            return list;
        } catch (SQLException ex) {
            System.err.println("Error at ProductDAO.getListBestSellProducts(): " + ex);
        }
        return null;
    }

    public List<Product> sort(List<Product> list, String sortBy, String sortType) {
        if (sortType.compareTo("ascending") == 0) {
            Collections.sort(list, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    switch (sortBy) {
                        case "name":
                            return o1.getName().compareTo(o2.getName());
                        case "price":
                            double o1Price = Double.parseDouble(o1.getPrice().split("-")[0]);
                            double o2Price = Double.parseDouble(o2.getPrice().split("-")[0]);
                            return o1Price < o2Price ? -1 : 1;
                        case "sold":
                            return o1.getSold() < o2.getSold() ? -1 : 1;
                    }
                    return 0;
                }
            });
        } else {
            Collections.sort(list, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    switch (sortBy) {
                        case "name":
                            return o2.getName().compareTo(o1.getName());
                        case "price":
                            double o1Price = Double.parseDouble(o1.getPrice().split("-")[0]);
                            double o2Price = Double.parseDouble(o2.getPrice().split("-")[0]);
                            return o2Price < o1Price ? -1 : 1;
                        case "sold":
                            return o2.getSold() < o1.getSold() ? -1 : 0;
                    }
                    return 0;
                }
            });
        }
        return list;
    }

    //Return the price range of a productTBL
    public String calculatePrice(int proID) {
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        List<Double> prices = proDetailDAO.getPrices(proID);
        if (!prices.isEmpty()) {
            Collections.sort(prices);
            if (prices.get(0).compareTo(prices.get(prices.size() - 1)) == 0) {
                return prices.get(0) + "";
            } else {
                return prices.get(0) + "-" + prices.get(prices.size() - 1);
            }
        }
        return "Unknown";
    }
}
