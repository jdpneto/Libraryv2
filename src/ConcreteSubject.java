
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
    ArrayList<Stat> statsState = new ArrayList<Stat>();

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
    public ArrayList<Stat> getState() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return statsState;
    }

    @Override
    public void setState(ArrayList<Stat> state) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.statsState = state;
    }

    @Override
    public void Notify() {
        for (Observer o: this.observers)
            o.update(this);
    }
    
}
