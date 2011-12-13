/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Originator {
    private Reader state;

    public Reader getState() {
        return state;
    }

    public void setState(Reader state) {
        this.state = state;
        System.out.println("Reader = " + state);
    }

    // Creates memento
    public Memento CreateMemento()
    {
      return (new Memento(this.state));
    }

    // Restores original state
    public void SetMemento(Memento memento)
    {
      System.out.println("Restoring Reader state...");
      this.state = memento.getState();
    }

}
