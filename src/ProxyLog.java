/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class ProxyLog implements Log{
    private String filename;
    private ConcreteLog log;
    
    public ProxyLog(String filename){
        this.filename = filename;
    }
    
    public String displayLog(){
        if(log == null){
            log = new ConcreteLog(this.filename);
        }
        return log.displayLog();
    }
    
    public void addLineToLog(String line){
        if(log == null){
            log = new ConcreteLog(this.filename);
        }
        log.addLineToLog(line);
    }
}
