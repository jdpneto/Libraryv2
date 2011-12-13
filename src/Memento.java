/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Memento {
    private Reader state;

    public Memento(Reader state) {
        this.state = state;
    }

    public Reader getState() {
        return this.state;
    }

    public void setState(Reader state) {
        this.state = state;
    }


}
