/*
 *     DuyDuc94
 */
package model;

import java.util.List;

public class Account {

    private int ID;
    private String Username;
    private String Password;
    private boolean Role;
    private boolean Status;
    private String Name;
    private String Phone;
    private String Email;

    public Account() {
    }

    public Account(int ID, String Username, String Password, boolean Role, boolean Status, String Name, String Phone, String Email) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
        this.Status = Status;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isRole() {
        return Role;
    }

    public void setRole(boolean Role) {
        this.Role = Role;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public double getTotalPriceInCart(List<Cart_Item> list) {
        double totalPriceInCart = 0;
        for (Cart_Item cart_Item : list) {
            totalPriceInCart += cart_Item.getPrice();
        }
        return totalPriceInCart;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User_Account{");
        sb.append("ID=").append(ID);
        sb.append(", Username=").append(Username);
        sb.append(", Password=").append(Password);
        sb.append(", Role=").append(Role);
        sb.append(", Status=").append(Status);
        sb.append(", Name=").append(Name);
        sb.append(", Phone=").append(Phone);
        sb.append(", Email=").append(Email);
        sb.append('}');
        return sb.toString();
    }

}
