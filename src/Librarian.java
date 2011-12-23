/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Librarian{
    private Person p;
    String expires;
    int[] type;
    
    public Librarian(Person p, String expires,int type[]){
        this.p = p;
        this.expires=expires;
        
    }
    
    public Librarian(){
        this.p = new Person();
    }
    
     public Person getPerson() {
        return p;
    }

    public void setPerson(Person p) {
        this.p = p;
    }
    
    public String getAddress() {
        return p.getAddress();//address;
    }

    public void setAddress(String address) {
        this.p.setAddress(address);// = address;
    }

    public String getCity() {
        return p.getCity();
    }

    public void setCity(String city) {
        this.p.setCity(city);//city = city;
    }

    public String getEmail() {
        return this.p.getEmail();
    }

    public void setEmail(String email) {
        this.p.setEmail(email);// = email;
    }

    public String getExpires() {
        return this.expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public int getId() {
        return this.p.getId();
    }

    public void setId(int id) {
        this.p.setId(id);//d = id;
    }

    public String getLogin() {
        return p.getLogin();//login;
    }

    public void setLogin(String login) {
        this.p.setLogin(login);//login = login;
    }

    public String getName() {
        return p.getName();//name;
    }

    public void setName(String name) {
        this.p.setName(name);// = name;
    }

    public String getPassword() {
        return p.getPassword();
    }

    public void setPassword(String password) {
        this.p.setPassword(password);// = password;
    }

    public String getPhone() {
        return p.getPhone();//phone;
    }

    public void setPhone(String phone) {
        this.p.setPhone(phone);// = phone;
    }

    public String getPostalcode() {
        return this.p.getPostalcode();
    }

    public void setPostalcode(String postalcode) {
        this.p.setPostalcode(postalcode);// = postalcode;
    }

    public int[] getType() {
        return this.type;
    }

    public void setType(int[] type) {
        this.type=type;//type = type;
    }
    
    public String getCountry() {
        return p.getCountry();//ountry;
    }

    public void setCountry(String country) {
        this.p.setCountry(country);// = country;
    }
    
}
