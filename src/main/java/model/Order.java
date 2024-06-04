/*
 * DuyDuc94
 */
package model;

import dal.AddressDAO;
import dal.OrderDAO;
import dal.Order_DetailDAO;
import java.util.Date;
import java.util.List;

/**
 * @author duy20
 */
public class Order {

    private int ID;
    private int UserID;
    private Date DateOrder;
    private int Status;
    private String ShippingAddress;
    private String PaymentMethod;

    public Order() {
    }

    public Order(int ID, int UserID, Date DateOrder, int Status, String ShippingAddress, String PaymentMethod) {
        this.ID = ID;
        this.UserID = UserID;
        this.DateOrder = DateOrder;
        this.Status = Status;
        this.ShippingAddress = ShippingAddress;
        this.PaymentMethod = PaymentMethod;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Date getDateOrder() {
        return DateOrder;
    }

    public void setDateOrder(Date DateOrder) {
        this.DateOrder = DateOrder;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String ShippingAddress) {
        this.ShippingAddress = ShippingAddress;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public List<Order_Detail> getOrderDetailList() {
        Order_DetailDAO orderDetailDAO = new Order_DetailDAO();
        return orderDetailDAO.getOrderDetailList(this.ID);
    }

    public String getStatusString() {
        if (this.Status == 1) {
            return "<span style=\"color: red\">Canceled (Wait shop to approved)</span>";
        }
        if (this.Status == 2) {
            return "<span style=\"color: green\">Preparing (Shop are preparing to ship)</span>";
        }
        if (this.Status == 3) {
            return "<span style=\"color: green\">Delivering (Product are on the way)</span>";
        }
        if (this.Status == 4) {
            return "<span style=\"color: green\">Deliveried (Delivery successful)</span>";
        }
        return "Unknow";
    }

    public double getTotalPrice() {
        OrderDAO orderDAO = new OrderDAO();
        return orderDAO.getTotalPrice(ID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("ID=").append(ID);
        sb.append(", UserID=").append(UserID);
        sb.append(", DateOrder=").append(DateOrder);
        sb.append(", Status=").append(Status);
        sb.append(", ShippingAddress=").append(ShippingAddress);
        sb.append(", PaymentMethod=").append(PaymentMethod);
        sb.append('}');
        return sb.toString();
    }

}
