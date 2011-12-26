
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class ImageObserver implements Observer {
    ArrayList<Stat> ObserverState;
    @Override
    public void update(Subject s) {
        this.ObserverState = s.getState();
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
