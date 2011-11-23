/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Address {
    
    private int id;
    private String street;
    private String city;
    private String postal_code;
    private String country;
    
    Address()
    {
        this.id = -1;
        this.street = "";
        this.city = "";
        this.postal_code = "";
        this.country = "";
    }
    
    Address(int id,String street, String city, String postal_code, String country)
    {
        this.id = id;
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
