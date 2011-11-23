

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */

import java.util.*;

public class Reader extends Person{
    
    private int limit;
    private ArrayList<Reservation> reservations;
    private Date expires;

    public Reader() {
        super();
        this.limit = -1;
        this.reservations = new ArrayList<Reservation>();
        this.expires = new Date();
    }

    public Reader(String name,int limit, Date expires, int id, String e_mail, Address address,int doornumber, String username, String password) {
        super(name,id,2, e_mail, address,doornumber, username, password);
        this.limit = limit;
        this.reservations = new ArrayList<Reservation>();
        this.expires = expires;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    
}
