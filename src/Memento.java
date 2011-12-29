/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Memento {
    private State state;

    public Memento(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }


}
