/*
 * DuyDuc94
 */
package model;

import dal.ProductOptionDAO;

/**
 * @author duy20
 */
public class Order_Detail {

    private int ID;
    private int ProDetailID;
    private int Quantity;
    private double Price;
    private int OrderID;

    public Order_Detail() {
    }

    public Order_Detail(int ID, int ProDetailID, int Quantity, double Price, int OrderID) {
        this.ID = ID;
        this.ProDetailID = ProDetailID;
        this.Quantity = Quantity;
        this.Price = Price;
        this.OrderID = OrderID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getProductDetatilName(){
        ProductOptionDAO proDetailDAO = new ProductOptionDAO();
        Product_Detail productDetail =  proDetailDAO.getProductOpt(this.ProDetailID);
        return proDetailDAO.getName(this.ProDetailID) + " " +  productDetail.getColor();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order_Detail{");
        sb.append("ID=").append(ID);
        sb.append(", ProDetailID=").append(ProDetailID);
        sb.append(", Quantity=").append(Quantity);
        sb.append(", Price=").append(Price);
        sb.append(", OrderID=").append(OrderID);
        sb.append('}');
        return sb.toString();
    }

}
