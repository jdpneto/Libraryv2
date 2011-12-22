/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class ImageObserver implements Observer {
    String ObserverState;
    @Override
    public void update(Subject o) {
        this.ObserverState = o.getState();
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
