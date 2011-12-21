
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class ConcreteSubject implements Subject {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    String statsState = "";

    @Override
    public void attach(Observer o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        observers.add(o);
        
    }

    @Override
    public void detach(Observer o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        observers.remove(o);
    }

    @Override
    public String getState() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return statsState;
    }

    @Override
    public void setState(String state) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.statsState = state;
    }
    
}
