/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class State {
    private Person p;
    private String expires;
    private int limit;
    
    public State(Person p, String expires, int limit)
    {
        this.p=p;
        this.expires=expires;
        this.limit=limit;
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

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
    
}
