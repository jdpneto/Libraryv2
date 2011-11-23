/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Admin extends Person{
    //private String auth_token;

    public Admin() {
        super();
//        this.auth_token = "";
    }

    public Admin(int id, String name, String e_mail, Address address,int doornumber, String username, String password) {
        super(name,id,0, e_mail, address,doornumber, username, password);
        //this.auth_token = auth_token;
    }
    
    
    
//    public String getAuthToken() {
//        return auth_token;
//    }
//
//    public void setAuthToken(String auth_token) {
//        this.auth_token = auth_token;
//    }
    
    
}
