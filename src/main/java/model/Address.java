/*
 * DuyDuc94
 */

package model;

/**
 * @author duy20
 */
public class Address {
    private int ID;
    private int UserID;
    private String Address;
    private String City;
    private boolean isDefault;

    public Address() {
    }

    public Address(int ID, String Address, String City, int UserID, boolean isDefault) {
        this.ID = ID;
        this.Address = Address;
        this.City = City;
        this.UserID = UserID;
        this.isDefault = isDefault;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
    
    public String getFullAddress(){
        return this.Address + ", " + this.City + " City";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append("ID=").append(ID);
        sb.append(", Address=").append(Address);
        sb.append(", City=").append(City);
        sb.append(", UserID=").append(UserID);
        sb.append(", isDefault=").append(isDefault);
        sb.append('}');
        return sb.toString();
    }
    
    
}
