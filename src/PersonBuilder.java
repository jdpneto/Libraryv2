/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 * 
 * 
 * 
 * ACHO QUE ISTO ESTÁ MAL E PRECISAMOS DE HIERARQUIA
 * Pelo menos acho que é assim que está no livro.
 * 
 * Esta implementação não é como a da wikipedia mas sim como a do livro
 * (acho que o barros quer esta)
 * 
 * 
 * 
 * 
 */
public class PersonBuilder {
    int id;
    String email;
    String address;
    String login;
    String password;
    String name;
    String postalcode;
    String city;
    String phone;
    String expires;
    String country;
    int[] type;

    public PersonBuilder() {
        
        this.id = -1;
        this.email = "";
        this.address = "";
        this.login = "";
        this.password = "";
        this.name = "";
        this.postalcode = "";
        this.city = "";
        this.phone = "";
        this.expires = "";
        this.type = new int[3];
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

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
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

    public int[] getType() {
        return type;
    }

    public void setType(int[] type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
     //public Person(int id, String email, String address, String login, String password, String name, String postalcode, String city, String phone, String expires, int[] type) {
   
    public Admin buildAdmin()
    {
        Person p =  new Person(id,email,address,login,password,name,postalcode,city,phone,expires,type,country);
        p.setExpires("UNLIMITED");
        Admin a = new Admin(p);
        return a;
    }
    public Librarian buildLibrarian()
    {
        Person p =  new Person(id,email,address,login,password,name,postalcode,city,phone,expires,type,country);
        p.setExpires("UNLIMITED");
        Librarian l = new Librarian (p);
        return l;
    }
    public Reader buildReader()
    {
        Person p =  new Person(id,email,address,login,password,name,postalcode,city,phone,expires,type,country);
        Reader r = new Reader (p);
        return r;
    }
    
    public Person buildPerson()
    {
        Person p =  new Person(id,email,address,login,password,name,postalcode,city,phone,expires,type,country);
        return p;
    }
}
