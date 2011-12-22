/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public interface Subject {
    
    public void Notify();
    public void attach(Observer o);
    public void detach(Observer o);
    public String getState();
    public void setState(String state);

}
