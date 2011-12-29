/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Memento {
    private Person state;

    public Memento(Person state) {
        this.state = state;
    }

    public Person getState() {
        return this.state;
    }

    public void setState(Person state) {
        this.state = state;
    }


}
