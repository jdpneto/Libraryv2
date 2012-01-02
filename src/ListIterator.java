/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class ListIterator<T> {
    int index;
    List<T> list;
    ListIterator(List<T> l)
    {
        this.list=l;
        index = 0;
    }
    
    public T First()
    {
        this.index = 0;
        return list.getElement(index++);
    }
    
    public T Next()
    {
        return list.getElement(index++);
    }
        
    public boolean IsDone()
    {//-1 porque começa em 0
        if(index < list.Count())
            return false;
        else
            return true;
    }
    public T CurrentItem()
    {
        return list.getElement(index);
    }
}
