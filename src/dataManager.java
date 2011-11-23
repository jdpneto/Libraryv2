/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */

//pois é

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.*;
import java.math.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dataManager {
    private Connection con;
    private Statement st;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    
    public dataManager(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=qwerty");
            st = (Statement) con.createStatement();
            resultSet = null;
            preparedStatement = null;
        } catch (Exception e) {
            System.err.println(e);
            
        }
        
    }
    //Obter a variável 'con'
    public Connection getCon() {
        return con;
    }
    
    //Obter a variável 'st'
    //teste final
    public Statement getSt() {
        return st;
    }
    
    //Obter a variável 'resultSet'
    public ResultSet getResultSet() {
        return resultSet;
    }
    
    //helper function to get md5 hashes
    public String getMd5(String pass)
    {
        try {
            MessageDigest m=MessageDigest.getInstance("MD5");
            m.update(pass.getBytes(),0,pass.length());
            return new BigInteger(1,m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(dataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "empty";
    }
    
    
    /***************ADDRESS*******************/
    
    public boolean storeAddress(String street, String city, String postalcode, String country)
    {
        try {
            String insert = "INSERT INTO Address (street,city,postalcode,country) "
                    + "VALUES('" + street + "','" + city + "','" + postalcode + "','" + country +"');";
            System.out.println(insert);
            st.execute(insert);
            return true;
            
            
        }catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public Address getAddressByStreet(String street)
    {
        String city;
        int id;
        //String street;
        String postalcode;
        String country;
        Address a = null;
        
        
        
        try{
            resultSet = st.executeQuery("select * from Address where street='"+street+"';");
            while(resultSet.next())
            {
                id = resultSet.getInt("idAddress");
                city = resultSet.getString("city");
                postalcode = resultSet.getString("postalcode");
                country = resultSet.getString("country");
                //Address(String street, String city, String postal_code, String country)
                a = new Address(id,street,city,postalcode,country);
            }
        }catch (Exception e) {
            System.err.println(e);
        }
        return a;
    }
    
    public Address getAddressById(int id)
    {
        String city;
        String street;
        String postalcode;
        String country;
        Address a = null;
        
        
        
        try{
            resultSet = st.executeQuery("select * from Address where idAddress="+id+";");
            while(resultSet.next())
            {
                city = resultSet.getString("city");
                street = resultSet.getString("street");
                postalcode = resultSet.getString("postalcode");
                country = resultSet.getString("country");
                //Address(String street, String city, String postal_code, String country)
                a = new Address(id,street,city,postalcode,country);
            }
        }catch (Exception e) {
            System.err.println(e);
        }
        return a;
    }
    
    
    /***************USERS*******************/
    
    public Date stringToDate(String d)
    {
        Date da = null;
        try {
            da = new SimpleDateFormat("dd/MM/yyyy").parse(d);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return da;
        
        
    }
    
    public String datetoString(Date d)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(d);
        return date;
    }
    
    
    
    public int checkLogin(String login, String pass)
    {
        String username;
        String hash;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                hash = resultSet.getString("md5_pass");
                if(hash.equals(getMd5(pass)))
                    return resultSet.getByte("type");
                else return -1;
            }
        }
        catch (Exception e) {
            System.err.println(e);
            return -2;
        }
        //nao existe utilizador
        return -2;
    }
    
    public boolean exists(String username)
    {
        try {
            resultSet = st.executeQuery("select * from User where login='" + username + "';");
            while (resultSet.next()) {
                return true;//resultSet.getInt("type");
            }
            return false;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
    
    

    
    
    public Admin getAdminByUsername(String login)
    {
        Admin a = null;
        int id = 0;
        int type = 0;
        Address addr = null;
        String name = null;
        String email = null;
        String pass = null;
        int doornumber = 0;
        //String expires = null;
        
        try{
            resultSet = st.executeQuery("select * from User where login='"+login+"';");
            while(resultSet.next())
            {
                id = resultSet.getInt("idUser");
                addr = getAddressById(resultSet.getInt("addr"));
                doornumber = resultSet.getInt("doornumber");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                pass = resultSet.getString("md5_pass");
                //expires = resultSet.getString("date");
                //public Admin(int id, String name, String e_mail, Address address, String username, String password) {
                
                a= new Admin(id,name,email,addr,doornumber,login,pass);
            }
            
            
        }catch (Exception e) {
            System.err.println(e);
            return a;
        }
        return a;
    }
    
    
    
    
    public Reader getReaderByUsername(String login)
    {
        Reader r = null;
        int id = 0;
        int type = 0;
        Address addr = null;
        String name = null;
        String email = null;
        String pass = null;
        int doornumber = 0;
        Date expires = null;
        
        try{
            resultSet = st.executeQuery("select * from User where login='"+login+"';");
            while(resultSet.next())
            {
                id = resultSet.getInt("idUser");
                addr = getAddressById(resultSet.getInt("addr"));
                doornumber = resultSet.getInt("doornumber");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                pass = resultSet.getString("md5_pass");
                expires = stringToDate(resultSet.getString("expires"));
                //public Admin(int id, String name, String e_mail, Address address, String username, String password) {
                //Reader(String name,int limit, Date expires, int id, String e_mail, Address address,int doornumber, String username, String password)
                
                r= new Reader(name,4,expires,id,email,addr,doornumber,login,pass);
            }
            
            
        }catch (Exception e) {
            System.err.println(e);
            return r;
        }
        return r;
    }
    
    
    public Librarian getLibrarianByUsername(String login)
    {
        Librarian l = null;
        int id = 0;
        int type = 0;
        Address addr = null;
        String name = null;
        String email = null;
        String pass = null;
        int doornumber = 0;
        //Date expires = null;
        
        try{
            resultSet = st.executeQuery("select * from User where login='"+login+"';");
            while(resultSet.next())
            {
                id = resultSet.getInt("idUser");
                addr = getAddressById(resultSet.getInt("addr"));
                doornumber = resultSet.getInt("doornumber");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                pass = resultSet.getString("md5_pass");
                //expires = stringToDate(resultSet.getString("expires"));
                //public Admin(int id, String name, String e_mail, Address address, String username, String password) {
                //Reader(String name,int limit, Date expires, int id, String e_mail, Address address,int doornumber, String username, String password)
                //public Librarian(String name, int id, String e_mail, Address address,int doornumber, String username, String password) {
                
                l= new Librarian(name,id,email,addr,doornumber,login,pass);//,4,expires,id,email,addr,doornumber,login,pass);
            }
            
            
        }catch (Exception e) {
            System.err.println(e);
            return l;
        }
        return l;
    }
    
    public boolean storeLibrarian(String name, String email, Address address,int doornumber, String username, String password)
    {
        if(exists(username))
            return false;
        try {
            String insert = "INSERT INTO User (name,login,email,md5_pass,doornumber,addr,type,expires) "
                    + "VALUES('" + name + "','" + username + "','" + email + "','" + getMd5(password) +"','"+doornumber+ "'," + address.getId() + ", " + 1 + ",'UNLIMITED');";
            System.out.println(insert);
            st.execute(insert);
            return true;
            
            
        }catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
        
    }
    
    public boolean storeReader(String name,int limit, Date expires, String email, Address address,int doornumber, String username, String password)
    {
        if(exists(username))
            return false;
        try {
            String insert = "INSERT INTO User (name,login,email,md5_pass,doornumber,addr,type,expires) "
                    + "VALUES('" + name + "','" + username + "','" + email + "','" + getMd5(password) +"','"+doornumber+ "'," + address.getId() + ", " + 2 + ",'"+datetoString(expires)+"');";
            System.out.println(insert);
            st.execute(insert);
            return true;
            
            
        }catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
    }
    public boolean storeAdmin(String name, String email, Address address,int doornumber, String username, String password)
    {
        if(exists(username))
            return false;
        try {
            String insert = "INSERT INTO User (name,login,email,md5_pass,doornumber,addr,type,expires) "
                    + "VALUES('" + name + "','" + username + "','" + email + "','" + getMd5(password) +"','"+doornumber+ "'," + address.getId() + ", " + 0 + ",'UNLIMITED');";
            System.out.println(insert);
            st.execute(insert);
            return true;
            
            
        }catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    public ArrayList<String> getReaders()
    {
        ArrayList<String> a = new ArrayList<String>();
        try {
            resultSet = st.executeQuery("select * from User");
            while (resultSet.next()) {
                if(resultSet.getInt("type")==2)
                    a.add(resultSet.getString("login"));
            }
            return a;
        } catch (Exception e) {
            System.err.println(e);
        }
        return a;
        
    }
    
    public ArrayList<String> getAdmins()
    {
        ArrayList<String> a = new ArrayList<String>();
        try {
            resultSet = st.executeQuery("select * from User");
            while (resultSet.next()) {
                if(resultSet.getInt("type")==0)
                    a.add(resultSet.getString("login"));
            }
            return a;
        } catch (Exception e) {
            System.err.println(e);
        }
        return a;
        
    }
    
    public ArrayList<String> getLibrarians()
    {
        ArrayList<String> a = new ArrayList<String>();
        try {
            resultSet = st.executeQuery("select * from User");
            while (resultSet.next()) {
                if(resultSet.getInt("type")==1)
                    a.add(resultSet.getString("login"));
            }
            return a;
        } catch (Exception e) {
            System.err.println(e);
        }
        return a;
    }
    
    public boolean removeUser(int id) throws SQLException {
        preparedStatement = (PreparedStatement) con.prepareStatement("DELETE FROM User WHERE idUser = " + id);
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    /************************BOOKS**************************/
    
    public boolean existsBook(String ISBN)
    {
        try {
            resultSet = st.executeQuery("select * from Book where ISBN='" + ISBN + "';");
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
    
    public Book getBookByISBN(String ISBN)
    {
       Book b = null;
       String author = "";
       String title = "";
       int year = 0;
       String cat = "";
       int ncopies = 0;
        
        try{
            resultSet = st.executeQuery("select * from User where ISBN='"+ISBN+"';");
            while(resultSet.next())
            {
                author = resultSet.getString("author");
                title = resultSet.getString("title");
                year = resultSet.getInt("year");
                cat = resultSet.getString("category");
                ncopies = resultSet.getInt("numberofcopies");
                //expires = stringToDate(resultSet.getString("expires"));
                //public Admin(int id, String name, String e_mail, Address address, String username, String password) {
                //Reader(String name,int limit, Date expires, int id, String e_mail, Address address,int doornumber, String username, String password)
                // Book(String isbn, String name, String author, Date year, String category, int number_of_copies, ArrayList<Comment> comments)
                //String isbn, String name, String author, int year, String category, int number_of_copies

                b = new Book(ISBN,title,author,year,cat,ncopies); //,email,addr,doornumber,login,pass);
            }
            
            
        }catch (Exception e) {
            System.err.println(e);
            return b;
        }
        return b;
    }
    
   // public Book getBookByName()
   // {}
    
    public boolean storeBook(String ISBN,String author, String title,int year, String cat, int ncopies)
    {
        if(existsBook(ISBN))
            return false;
        try {
            String insert = "INSERT INTO Book (ISBN,author,title,year,category,numberofcopies) "
                    + "VALUES('" + ISBN + "','" 
                    + author + "','" 
                    + title + "'," 
                    + year +",'" 
                    + cat+ "'," 
                    + ncopies + ");";
            System.out.println(insert);
            st.execute(insert);
            return true;
            
            
        }catch (Exception e) {
            System.err.println(e);
            return false;
        }
        
    }

}
