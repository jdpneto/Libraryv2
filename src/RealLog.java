/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jlnabais
 */
public class RealLog implements Log{
    private String filename;
    private String log;
    
    public RealLog(String filename){
        this.filename = filename;
        loadLog();
    }
    
    public String displayLog(){
        return this.log;
    }
    
    
    private void loadLog(){
        System.out.println("Loading " + this.filename);
        StringBuilder contents = new StringBuilder();
        try{
            
            BufferedReader input =  new BufferedReader(new FileReader(this.filename));
            
            String line = null;
            while (( line = input.readLine()) != null){
          contents.append(line);
          contents.append(System.getProperty("line.separator"));
        }            
        }catch(Exception e){
            log = "";
        }
        log = contents.toString();
    }
    
    public void addLineToLog(String line){
        line += "\n";
        this.log += line;
    }
}
