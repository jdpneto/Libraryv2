/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class AdminBuilder  extends PersonBuilder{

    public AdminBuilder() {

    }
        public Admin Build()
    {
        Person p =  new Person(this.id, this.email, this.address, this.login, this.password, this.name, this.postalcode, this.city, this.phone, this.type, this.country);
        Admin a = new Admin(p);
        return a;
    }
}
