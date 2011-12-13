/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class LibrarianBuilder  extends PersonBuilder{

    public LibrarianBuilder() {
        this.expires = null;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }



    public Librarian Build()
    {
        Person p =  new Person(this.id, this.email, this.address, this.login, this.password, this.name, this.postalcode, this.city, this.phone, this.type, this.country);
        Librarian l = new Librarian (p, this.expires);
        return l;
    }

}
