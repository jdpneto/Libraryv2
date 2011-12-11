/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jlnabais
 */
public class ConcreteLog implements Log{
    private String filename;
    private String log;
    
    public ConcreteLog(String filename){
        this.filename = filename;
        loadLog();
    }
    
    public String displayLog(){
        return this.log;
    }
    
    public void storeLog(){
        try{
            
            FileOutputStream fout = new FileOutputStream(this.filename);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this.log);
            oos.close();
            System.out.println("Log saved!");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadLog(){
        System.out.println("Loading " + this.filename);
        try{
            
            FileInputStream fin = new FileInputStream(this.filename);
            ObjectInputStream ois = new ObjectInputStream(fin);
            this.log = (String)ois.readObject();
            ois.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addLineToLog(String line){
        line += "\n";
        this.log += line;
    }
}
