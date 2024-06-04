/*
 *     DuyDuc94
 */
package lib;

public class MyValidated {
    
    public static boolean isLegitName(String name){
        String regex = "^[\\p{L}\\p{M}]+(\\s[\\p{L}\\p{M}]+)*$";
        return name.matches(regex);
    }
    
    public static boolean isLegitUsername(String username){
        String regex = "^[a-zA-Z0-9]+$";
        return username.matches(regex) && (username.length()>6&&username.length()<12);
    }
    
    public static boolean isLegitPhone(String phone){
        String regex = "^[0-9]+$";
        return phone.matches(regex) && phone.length()>9;
    }
    
    public static boolean isLegitEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
}
