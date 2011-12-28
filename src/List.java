
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class List<T> {
    ArrayList<T> list;
    public List()
    {
        this.list = new ArrayList<T>();
    }
    
    public int Count()
    {
        return this.list.size();
    }
    public void Append(T element)
    {
        this.list.add(element);
    }
    public void Remove(T element)
    {
        this.list.remove(element);
    }
    
    public T getElement(int i)
    {
        return this.list.get(i);
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0; i< list.size(); i++)
            ret+=list.get(i)+" ";
        return ret;
    }
    
    
}
