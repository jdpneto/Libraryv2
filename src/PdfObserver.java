
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class PdfObserver implements Observer {

    ArrayList<Stat> ObserverState;
    @Override
    public void update(Subject s) {
        //throw new UnsupportedOperationException("Not supported yet.");
        ObserverState = s.getState();
    }
    
}
