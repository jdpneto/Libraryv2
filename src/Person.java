/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Person {
    
    protected int id;
    //protected String phone_number;
    protected String e_mail;
    protected Address address;
    protected String username;
    protected String password;
    protected String name;
    protected int type;
    protected int doornumber;
    
    Person()
    {
        this.name = "";
        this.id = -1;
       // this.phone_number = "";
        this.e_mail = "";
        this.address = new Address();
        this.username = "";
        this.password = "";
        this.type = -1;
        this.doornumber = -1;
    }
    
    Person(String name, int id,int type, String e_mail, Address address,int doornumber, String username, String password)
    {
        this.name = name;
        this.id = id;
        this.doornumber = doornumber;
       // this.phone_number = phone_number;
        this.e_mail = e_mail;
        this.address = address;
        this.username = username;
        this.password = password;
        this.type = type;
    }
    
    public void changeAddress(Address address){
        this.setAddress(address);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getPhoneNumber() {
//        return phone_number;
//    }
//
//    public void setPhoneNumber(String phone_number) {
//        this.phone_number = phone_number;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}