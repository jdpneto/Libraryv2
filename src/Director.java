/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class Director {
    Builder b;
    public Director(Builder b)
    {
        this.b = b;
    }
    
    public void Construct(Person p, int[] type, String date, int limit)
    {
        b.buildPerson(p);
        b.buildType(type);
        b.buildExpires(date);
        b.buildLimit(limit);
    }
}
