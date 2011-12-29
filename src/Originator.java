/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Originator {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("State = " + state);
    }

    // Creates memento
    public Memento CreateMemento()
    {
      return (new Memento(this.state));
    }

    // Restores original state
    public void SetMemento(Memento memento)
    {
      System.out.println("Restoring Person state...");
      this.state = memento.getState();
    }

}
