/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class PdfObserver implements Observer {

    String ObserverState;
    @Override
    public void notify(Subject o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        ObserverState = o.getState();
    }
    
}
