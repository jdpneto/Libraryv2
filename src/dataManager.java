/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */

//pois é
//poist é v2
//TODO: MUDAR AS QUERIES DE SQL DOS USERS PARA O NOVO FORMATO
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
    
    //just because I sometipes use toMd5
    public String toMd5(String pass)
    {
        return getMd5(pass);
    }
    
    
    /***************ADDRESS******************
     
     * NOT NEEDED IN THE NEW DB SCHEME
     
     */
//    
//    public boolean existsStreet(String street, String postalcode)
//    {
//        String tmpPostalCode = "";
//        try {
//            resultSet = st.executeQuery("select * from Address where street='" + street + "';");
//            while (resultSet.next()) {
//                tmpPostalCode = resultSet.getString("postalcode");
//                if(tmpPostalCode.equals(postalcode))
//                    return true;
//            }
//            return false;
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        return false;
//    }
//    
//    public boolean storeAddress(String street, String city, String postalcode, String country)
//    {
//        if(existsStreet(street,postalcode))
//            return false;
//        try {
//            String insert = "INSERT INTO Address (street,city,postalcode,country) "
//                    + "VALUES('" + street + "','" + city + "','" + postalcode + "','" + country +"');";
//            System.out.println(insert);
//            st.execute(insert);
//            return true;
//            
//            
//        }catch (Exception e) {
//            System.err.println(e);
//            return false;
//        }
//    }
//    
//    public Address getAddressByStreet(String street)
//    {
//        String city;
//        int id;
//        //String street;
//        String postalcode;
//        String country;
//        Address a = null;
//        
//        
//        
//        try{
//            resultSet = st.executeQuery("select * from Address where street='"+street+"';");
//            while(resultSet.next())
//            {
//                id = resultSet.getInt("idAddress");
//                city = resultSet.getString("city");
//                postalcode = resultSet.getString("postalcode");
//                country = resultSet.getString("country");
//                //Address(String street, String city, String postal_code, String country)
//                a = new Address(id,street,city,postalcode,country);
//            }
//        }catch (Exception e) {
//            System.err.println(e);
//        }
//        return a;
//    }
//    
//    public Address getAddressById(int id)
//    {
//        String city;
//        String street;
//        String postalcode;
//        String country;
//        Address a = null;
//        
//        
//        
//        try{
//            resultSet = st.executeQuery("select * from Address where idAddress="+id+";");
//            while(resultSet.next())
//            {
//                city = resultSet.getString("city");
//                street = resultSet.getString("street");
//                postalcode = resultSet.getString("postalcode");
//                country = resultSet.getString("country");
//                a = new Address(id,street,city,postalcode,country);
//            }
//        }catch (Exception e) {
//            System.err.println(e);
//        }
//        return a;
//    }
    
    
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
    
    
    
//    public int checkLogin(String login, String pass)
    
    //if returned object equals the sent one, then
    //it is an invalid login
    public Person checkLogin(Person p)
    {
        //String login;
        String hash;
        PersonBuilder pb;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + p.getLogin() + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                hash = resultSet.getString("md5_pass");
                if(hash.equals(getMd5(p.getPassword())))
                {
                    int[] type = new int[3];
                    type[0] = resultSet.getInt("adminaccess");
                    type[1] = resultSet.getInt("readeraccess");
                    type[2] = resultSet.getInt("librarianaccess");
                    pb = new PersonBuilder();
                            pb.setId(resultSet.getInt("idUser"));
                            pb.setAddress(resultSet.getString("address"));
                            pb.setName(resultSet.getString("name"));
                            pb.setLogin(resultSet.getString("login"));
                            pb.setEmail(resultSet.getString("email"));
                            pb.setPassword(hash);
                            pb.setExpires(resultSet.getString("expires"));
                            pb.setPostalcode(resultSet.getString("postalcode"));
                            pb.setCity(resultSet.getString("city"));
                            pb.setCountry(resultSet.getString("country"));
                            pb.setPhone(resultSet.getString("phonenumber"));
                            
                    return pb.buildPerson();//resultSet.getByte("type");
                }
                else return p;
            }
        }
        catch (Exception e) {
            System.err.println(e);
            return p;
        }
        //nao existe utilizador
        return p;
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
    
    public boolean editUser(int id, String name, String email, String expires)
    {
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement("UPDATE User SET name='" + name + ",email='" + email + "',expires='" + expires + "' WHERE idUser = " + id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e);
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
    
    public Book getBookByTitle(String title)
    {
        Book b = null;
        String author = "";
        String ISBN = "";
        int year = 0;
        String cat = "";
        int ncopies = 0;
        
        try{
            resultSet = st.executeQuery("select * from User where ISBN='"+ISBN+"';");
            while(resultSet.next())
            {
                author = resultSet.getString("author");
                ISBN = resultSet.getString("ISBN");
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
