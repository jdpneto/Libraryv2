/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class AdminBuilder  implements Builder{
    
    private Person p;
    private int[] type;
    
    public AdminBuilder() {

    }

    @Override
    public void buildPerson(Person p) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.p=p;
    }

    @Override
    public void buildType(int[] type) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.type=type;
    }

    @Override
    public void buildExpires(String date) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void buildLimit(int limit) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Admin getResult()
    {
        return new Admin(p,type);
    }
}
