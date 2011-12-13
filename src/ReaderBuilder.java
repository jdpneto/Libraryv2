/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class ReaderBuilder extends PersonBuilder{

    public ReaderBuilder() {
        super();
        this.limit = -1;
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

        public Reader Build()
    {
        Person p =  new Person(this.id, this.email, this.address, this.login, this.password, this.name, this.postalcode, this.city, this.phone, this.type, this.country);
        Reader r = new Reader(p, this.limit, this.expires);

        return r;
    }
}
