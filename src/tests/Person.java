package tests;


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
    protected String email;
    protected String address;
    protected String login;
    protected String password;
    protected String name;
    protected String postalcode;
    protected String city;
    protected String country;
    protected String phone;
    //protected int[] type;

    public Person() {
        this.id = -1;
        this.email = "";
        this.address = "";
        this.login = "";
        this.password = "";
        this.name = "";
        this.postalcode = "";
        this.city = "";
        this.phone = "";
        this.country = "";
       // this.type = new int[3];
        
    }

    
    public Person(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public Person(int id, String email, String address, String login, String password, String name, String postalcode, String city, String phone, String country) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.login = login;
        this.password = password;
        this.name = name;
        this.postalcode = postalcode;
        this.city = city;
        this.phone = phone;
       // this.type = type;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    
    
    // {
        
    public Person clone()
    {
        return new Person(id, email, address, login, password, name, postalcode, city, phone, country);
    }



    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", email=" + email + ", address=" + address + ", login=" + login + ", password=" + password + ", name=" + name + ", postalcode=" + postalcode + ", city=" + city + ", country=" + country + ", phone=" + phone + '}';
    }
    
}