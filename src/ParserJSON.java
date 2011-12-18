


import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jlnabais
 */
public class ParserJSON implements Parser{

    public void toFile(ArrayList<Book> books){

        Gson gson = new Gson();

        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(books);

        try {
            //write converted json data to a file named "books.json"
            FileWriter writer = new FileWriter("books.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(json);

    }

}
