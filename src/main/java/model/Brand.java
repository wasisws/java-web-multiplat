/*
 *     DuyDuc94
 */
package model;

import dal.ProductDAO;

public class Brand {

    private int ID;
    private String Name;

    public Brand() {
    }

    public Brand(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public int getQuantity(){
        ProductDAO proDAO = new ProductDAO();
        return proDAO.getProductOfBrand(this.Name).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand{");
        sb.append("ID=").append(ID);
        sb.append(", Name=").append(Name);
        sb.append('}');
        return sb.toString();
    }

}
