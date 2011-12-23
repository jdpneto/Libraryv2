/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class ReaderBuilder implements Builder{

    private Person p;
    private int[] type;
    private String date;
    private int limit;
    
    public ReaderBuilder() {
    }

    @Override
    public void buildPerson(Person p) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.p = p;
    }

    @Override
    public void buildType(int[] type) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.type = type;
    }

    @Override
    public void buildExpires(String date) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.date = date;
    }

    @Override
    public void buildLimit(int limit) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.limit=limit;
    }
    
    public Reader getResult()
    {
        return new Reader(p,limit,date,type);
    }

}
