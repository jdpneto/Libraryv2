
import java.util.ArrayList;

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
    public ArrayList<Stat> getState();
    public void setState(ArrayList<Stat> state);

}
