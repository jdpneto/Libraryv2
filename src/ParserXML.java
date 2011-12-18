


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class ParserXML implements Parser{

    public void toFile(ArrayList<Book> books){

        XStream xstream = new XStream(new DomDriver());
        String xml = xstream.toXML(books);
        //System.out.println(xml);

         try {
            //write converted json data to a file named "books.xml"
            FileWriter writer = new FileWriter("books.xml");
            writer.write(xml);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
