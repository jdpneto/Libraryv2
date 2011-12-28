/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Main {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println(dat.checkLogin("admin", "admin"));
        //System.out.println(dat.checkLogin("admin", "nonadmin"));
        List<String> tmp = new List<String>();
        
        tmp.Append("a");
        tmp.Append("b");
        tmp.Append("c");
        tmp.Append("d");
        
        System.out.println(tmp);
        
        ListIterator<String> iter = new ListIterator<String>(tmp);
        
        System.out.println(iter.First());
        while(!iter.IsDone())
            System.out.println(iter.Next());
        
        
        
        new LoginForm().setVisible(true);
        
    }
    
}
