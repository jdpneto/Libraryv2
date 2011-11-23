/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Librarian extends Person{
    public Librarian(String name, int id, String e_mail, Address address,int doornumber, String username, String password) {
        super(name,id,1, e_mail, address,doornumber, username, password);
        this.name = name;
    }
}
