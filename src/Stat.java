/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class Stat {
    
    String type;
    int value;
    
    public Stat(){
    this.type = "";
    this.value= 0;
    }
    public Stat(String type, int value){
    this.type = type;
    this.value= value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public void addOne()
    {
        this.value++;
    }

    @Override
    public String toString() {
        return "Stat{" + "type=" + type + ", value=" + value + '}';
    }
    
    
}
