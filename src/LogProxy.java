/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class LogProxy implements Log{
    private String filename;
    private RealLog log;
    
    public LogProxy(String filename){
        this.filename = filename;
    }
    
    public String displayLog(){
        if(log == null){
            log = new RealLog(this.filename);
        }
        return log.displayLog();
    }
    
    public void addLineToLog(String line){
        if(log == null){
            log = new RealLog(this.filename);
        }
        log.addLineToLog(line);
    }
}
