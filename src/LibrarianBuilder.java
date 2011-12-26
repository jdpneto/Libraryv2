/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class LibrarianBuilder implements Builder{
    
    private Person p;
    private int[] type;
    private String expires;
    
    LibrarianBuilder(){
        
    }

    @Override
    public void buildPerson(Person p) {
       this.p = p;
    }

    @Override
    public void buildType(int[] type) {
        this.type=type;
    }

    @Override
    public void buildExpires(String date) {
        this.expires=expires;
    }

    @Override
    public void buildLimit(int limit) {
        
    }
    
    public Librarian getResult()
    {
        return new Librarian(p,expires,type);
    }
}
