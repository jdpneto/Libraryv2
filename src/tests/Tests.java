/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Tests {

    /**
     * 
     * @param args the command line arguments
     */
    private static Connection con;
    private static Statement st;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    /*******OBJSERVER STATE AND SUBJECTS************/
   
   
       

    public static void main(String[] args) throws IOException {
             try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=qwerty");
            st = (Statement) con.createStatement();
            resultSet = null;
            preparedStatement = null;
            
            
            getCommentsByBook("9780552552097");
            
            
            } catch (Exception e) {
            System.err.println(e);

        }
        
    }
        public static ArrayList<Comment> getCommentsByBook(String ISBN) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        try {
            //System.out.println("select rating from Review where book_ISBN='" + ISBN + "';");
            resultSet = st.executeQuery("select * from Review where book_ISBN='" + ISBN + "';");
            Comment tmp;
            //System.out.print(resultSet);
            while (resultSet.next()) {
                tmp = new Comment();
                tmp.setId(resultSet.getInt("idReview"));
                tmp.setBook(resultSet.getString("book_ISBN"));
               // tmp.setCommenter(getReaderById(resultSet.getInt("user_id")));
                tmp.setRating(resultSet.getInt("book_r"));
                comments.add(tmp);
            }
            return comments;

        } catch (Exception e) {
            System.err.println(e);
        }
        return comments;
    }
    
}
