/*
 *     DuyDuc94
 */
package model;

import dal.ProductOptionDAO;

public class Product_Detail {

    private int ID;
    private int ProID;
    private int Quantity;
    private double Price;
    private String Image;
    private String Color;

    public Product_Detail() {
    }

    public Product_Detail(int ID, int ProID, int Quantity, double Price, String Image, String Color) {
        this.ID = ID;
        this.ProID = ProID;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Image = Image;
        this.Color = Color;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int ProID) {
        this.ProID = ProID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product_Detail{");
        sb.append("ID=").append(ID);
        sb.append(", ProID=").append(ProID);
        sb.append(", Quantity=").append(Quantity);
        sb.append(", Price=").append(Price);
        sb.append(", Image=").append(Image);
        sb.append(", Color=").append(Color);
        sb.append('}');
        return sb.toString();
    }

}
