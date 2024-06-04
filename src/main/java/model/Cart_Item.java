/*
 *     DuyDuc94
 */
package model;

import dal.CartDAO;
import dal.ProductOptionDAO;

public class Cart_Item {

    private int ID;
    private int UserID;
    private int ProDetailID;
    private int Quantity;
    private String image;

    public Cart_Item() {
    }

    public Cart_Item(int ID, int CartID, int ProDetailID, int Quantity, String image) {
        this.ID = ID;
        this.UserID = CartID;
        this.ProDetailID = ProDetailID;
        this.Quantity = Quantity;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCartID() {
        return UserID;
    }

    public void setCartID(int CartID) {
        this.UserID = CartID;
    }

    public int getProDetailID() {
        return ProDetailID;
    }

    public void setProDetailID(int ProDetailID) {
        this.ProDetailID = ProDetailID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    public int getProductID(){
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        return proDetailDAO.getProductOpt(ProDetailID).getProID();
    }
    
    public String getProductName(){
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        return proDetailDAO.getName(this.ProDetailID);
    }
    
    public String getProductColor(){
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        return proDetailDAO.getProductOpt(this.ProDetailID).getColor();
    }
    
    public double getPrice(){
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        return (double)this.Quantity * proDetailDAO.getProductOpt(ProDetailID).getPrice();
    }
    
    public String getImage(){
        return this.image;
    }
    
}
