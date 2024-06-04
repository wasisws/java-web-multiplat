/*
 *     DuyDuc94
 */
package model;

import dal.BrandDAO;
import dal.CategoryDAO;
import dal.ProductOptionDAO;
import dal.WishlistDAO;
import java.util.List;

public class Product {

    private int ID;
    private int BrandID;
    private int CateID;
    private String BrandName;
    private String CategoryName;
    private String Name;
    private String Description;
    private String Image;
    private String Price;
    private int Sold;

    public Product() {
    }

    public Product(int ID, int BrandID, int CateID, String BrandName, String CategoryName, String Name, String Description, String Image, String Price, int Sold) {
        this.ID = ID;
        this.BrandID = BrandID;
        this.CateID = CateID;
        this.BrandName = BrandName;
        this.CategoryName = CategoryName;
        this.Name = Name;
        this.Description = Description;
        this.Image = Image;
        this.Price = Price;
        this.Sold = Sold;
    }

    public int getID() {
        return ID;
    }

    public int getBrandID() {
        return BrandID;
    }

    public int getCateID() {
        return CateID;
    }

    public String getBrandName() {
        return BrandName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getImage() {
        return Image;
    }

    public String getPrice() {
        return Price;
    }

    public int getSold() {
        return Sold;
    }

    public int getQuantity() {
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        List<Product_Detail> list = proDetailDAO.getProductOptList(this.ID);
        int Quantity = 0;
        for (Product_Detail product_Detail : list) {
            Quantity += product_Detail.getQuantity();
        }
        return Quantity;
    }

    public boolean isInWishlist(int userID) {
        if (userID < 0) {
            return false;
        } else {
            WishlistDAO wishlistDAO = new WishlistDAO();
            List<Product> wishlist = wishlistDAO.getWishlistOf(userID);
            for (Product productWishlist : wishlist) {
                if (this.ID == productWishlist.getID()) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("ID=").append(ID);
        sb.append(", BrandID=").append(BrandID);
        sb.append(", CateID=").append(CateID);
        sb.append(", BrandName=").append(BrandName);
        sb.append(", CategoryName=").append(CategoryName);
        sb.append(", Name=").append(Name);
        sb.append(", Description=").append(Description);
        sb.append(", Image=").append(Image);
        sb.append(", Price=").append(Price);
        sb.append(", Sold=").append(Sold);
        sb.append('}');
        return sb.toString();
    }

}
