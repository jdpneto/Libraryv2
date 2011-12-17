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
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.*;
import java.math.*;
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
    //Every method but this one will recieve an already hashed password
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
                            //não acho que passes devam ser trocadas para trás e para a frente
                            //o método já verificou a pass, não será preciso
                            pb.setPassword(hash);
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
    
    
    //person storage helper
    private boolean existsPerson(String login)
    {
        try {
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            while (resultSet.next()) {
                return true;//resultSet.getInt("type");
            }
            return false;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
    
    
    
    
    public Person getPerson(String login)
    {
        Person p = new Person();
        PersonBuilder pb;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
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
                            pb.setPassword(resultSet.getString("md5_pass"));
                            pb.setPostalcode(resultSet.getString("postalcode"));
                            pb.setCity(resultSet.getString("city"));
                            pb.setCountry(resultSet.getString("country"));
                            pb.setPhone(resultSet.getString("phonenumber"));
                    
                    return pb.buildPerson();//resultSet.getByte("type");
                
            }
        }
        catch (Exception e) {
            System.err.println(e);
            return p;
        }
        //nao existe utilizador
        return p;
    }
    public Admin getAdmin(String login)
    {
        AdminBuilder pb;
        Admin a = new Admin();
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                    int[] type = new int[3];
                    type[0] = resultSet.getInt("adminaccess");
                    type[1] = resultSet.getInt("readeraccess");
                    type[2] = resultSet.getInt("librarianaccess");
                    pb = new AdminBuilder();
                            pb.setId(resultSet.getInt("idUser"));
                            pb.setAddress(resultSet.getString("address"));
                            pb.setName(resultSet.getString("name"));
                            pb.setLogin(resultSet.getString("login"));
                            pb.setEmail(resultSet.getString("email"));
                            pb.setPassword(resultSet.getString("md5_pass"));
                            pb.setPostalcode(resultSet.getString("postalcode"));
                            pb.setCity(resultSet.getString("city"));
                            pb.setCountry(resultSet.getString("country"));
                            pb.setPhone(resultSet.getString("phonenumber"));
                    
                    return pb.Build();//resultSet.getByte("type");
                
            }
        }
        catch (Exception e) {
            System.err.println(e);
            return a;
        }
        //nao existe utilizador
        return a;
    }
    
    
    
    
    public Reader getReader(String login)
    {
        Reader r = new Reader();
        ReaderBuilder pb;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                    int[] type = new int[3];
                    type[0] = resultSet.getInt("adminaccess");
                    type[1] = resultSet.getInt("readeraccess");
                    type[2] = resultSet.getInt("librarianaccess");
                    pb = new ReaderBuilder();
                            pb.setId(resultSet.getInt("idUser"));
                            pb.setAddress(resultSet.getString("address"));
                            pb.setName(resultSet.getString("name"));
                            pb.setLogin(resultSet.getString("login"));
                            pb.setEmail(resultSet.getString("email"));
                            pb.setPassword(resultSet.getString("md5_pass"));
                            pb.setExpires(resultSet.getString("expires"));
                            pb.setLimit(resultSet.getInt("limit"));
                            pb.setPostalcode(resultSet.getString("postalcode"));
                            pb.setCity(resultSet.getString("city"));
                            pb.setCountry(resultSet.getString("country"));
                            pb.setPhone(resultSet.getString("phonenumber"));
                    
                    return pb.Build();//resultSet.getByte("type");
                
            }
        }
        catch (Exception e) {
            System.err.println(e);
            return r;
        }
        //nao existe utilizador
        return r;
    }
        public Reader getReaderById(int id)
    {
        Reader r = new Reader();
        ReaderBuilder pb;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where idUser='" + id + "';");
            
            while (resultSet.next()) {
                    int[] type = new int[3];
                    type[0] = resultSet.getInt("adminaccess");
                    type[1] = resultSet.getInt("readeraccess");
                    type[2] = resultSet.getInt("librarianaccess");
                    pb = new ReaderBuilder();
                            pb.setId(resultSet.getInt("idUser"));
                            pb.setAddress(resultSet.getString("address"));
                            pb.setName(resultSet.getString("name"));
                            pb.setLogin(resultSet.getString("login"));
                            pb.setEmail(resultSet.getString("email"));
                            pb.setPassword(resultSet.getString("md5_pass"));
                            pb.setExpires(resultSet.getString("expires"));
                            pb.setLimit(resultSet.getInt("limit"));
                            pb.setPostalcode(resultSet.getString("postalcode"));
                            pb.setCity(resultSet.getString("city"));
                            pb.setCountry(resultSet.getString("country"));
                            pb.setPhone(resultSet.getString("phonenumber"));
                    
                    return pb.Build();//resultSet.getByte("type");
                
            }
        }
        catch (Exception e) {
            System.err.println(e);
            return r;
        }
        //nao existe utilizador
        return r;
    }
    
    
    public Librarian getLibrarian(String login)
    {
        Librarian l = new Librarian();
        LibrarianBuilder pb;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                    int[] type = new int[3];
                    type[0] = resultSet.getInt("adminaccess");
                    type[1] = resultSet.getInt("readeraccess");
                    type[2] = resultSet.getInt("librarianaccess");
                    pb = new LibrarianBuilder();
                            pb.setId(resultSet.getInt("idUser"));
                            pb.setAddress(resultSet.getString("address"));
                            pb.setName(resultSet.getString("name"));
                            pb.setLogin(resultSet.getString("login"));
                            pb.setEmail(resultSet.getString("email"));
                            pb.setPassword(resultSet.getString("md5_pass"));
                            pb.setExpires(resultSet.getString("expires"));
                            pb.setPostalcode(resultSet.getString("postalcode"));
                            pb.setCity(resultSet.getString("city"));
                            pb.setCountry(resultSet.getString("country"));
                            pb.setPhone(resultSet.getString("phonenumber"));
                    
                    return pb.Build();//resultSet.getByte("type");
                
            }
        }
        catch (Exception e) {
            System.err.println(e);
            return l;
        }
        //nao existe utilizador
        return l;
    }
    
    public Librarian storeLibrarian(Librarian l)
    {
        if(existsPerson(l.getLogin()))
            return l;
        try {
            int[] type = l.getType();
            String insert = "INSERT INTO User (name,login,email,md5_pass,expires,address,postalcode,city,country,adminaccess,readeraccess,librarianaccess,phonenumber) "
                    + "VALUES('" 
                    + l.getName() + "','" 
                    + l.getLogin() + "','" 
                    + l.getEmail() + "','" 
                    + l.getPassword() +"','"
                    + l.getExpires() + "','" 
                    + l.getAddress() + "', '" 
                    + l.getPostalcode() + "', '"
                    + l.getCity() + "', '"
                    + l.getCountry() + "', "
                    + type[0] + ", "
                    + type[1] + ", "
                    + type[2] + ", '"
                    + l.getPhone() + "');";
            System.out.println(insert);
            st.execute(insert);
            return getLibrarian(l.getLogin());
            
            
        }catch (Exception e) {
            System.err.println(e);
            return l;
        }
    }
    
    public Reader storeReader(Reader r)
    {
        if(existsPerson(r.getLogin()))
            return r;
        try {
            int[] type = r.getType();
            String insert = "INSERT INTO User (name,login,email,md5_pass,expires,address,postalcode,city,country,adminaccess,readeraccess,librarianaccess,phonenumber) "
                    + "VALUES('" 
                    + r.getName() + "','" 
                    + r.getLogin() + "','" 
                    + r.getEmail() + "','" 
                    + r.getPassword() +"','"
                    + r.getExpires() + "','" 
                    + r.getAddress() + "', '" 
                    + r.getPostalcode() + "', '"
                    + r.getCity() + "', '"
                    + r.getCountry() + "', "
                    + type[0] + ", "
                    + type[1] + ", "
                    + type[2] + ", '"
                    + r.getPhone() + "');";
            System.out.println(insert);
            st.execute(insert);
            return getReader(r.getLogin());
            
            
        }catch (Exception e) {
            System.err.println(e);
            return r;
        }
        
    }
    public Admin storeAdmin(Admin a)
    {
        if(existsPerson(a.getLogin()))
            return a;
        try {
            int[] type = a.getType();
            String insert = "INSERT INTO User (name,login,email,md5_pass,expires,address,postalcode,city,country,adminaccess,readeraccess,librarianaccess,phonenumber) "
                    + "VALUES('" 
                    + a.getName() + "','" 
                    + a.getLogin() + "','" 
                    + a.getEmail() + "','" 
                    + a.getPassword() +"','"
                    + a.getAddress() + "', '" 
                    + a.getPostalcode() + "', '"
                    + a.getCity() + "', '"
                    + a.getCountry() + "', "
                    + type[0] + ", "
                    + type[1] + ", "
                    + type[2] + ", '"
                    + a.getPhone() + "');";
            System.out.println(insert);
            st.execute(insert);
            return getAdmin(a.getLogin());
            
            
        }catch (Exception e) {
            System.err.println(e);
            return a;
        }
    }
    
    public ArrayList<String> getReaders()
    {
        ArrayList <String> a = new ArrayList<String>();
        
        try {
            resultSet = st.executeQuery("select * from User where readeraccess = 1");
            while (resultSet.next()) {
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
        ArrayList <String> a = new ArrayList<String>();
        try {
            resultSet = st.executeQuery("select * from User where adminaccess = 1");
            while (resultSet.next()) {
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
        ArrayList <String> a = new ArrayList<String>();
        try {
            resultSet = st.executeQuery("select * from User where librarianaccess = 1");
            while (resultSet.next()) {
                a.add(resultSet.getString("login"));
            }
            return a;
        } catch (Exception e) {
            System.err.println(e);
        }
        return a;
    }
    
    public Person removeUser(Person p) throws SQLException {
        preparedStatement = (PreparedStatement) con.prepareStatement("DELETE FROM User WHERE idUser = " + p.getId());
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            return new Person();
        } else {
            return p;
        }
    }
    
    public Person editUser(Person p)
    {
        //TODO: POSSIVEL IMPLEMENTACAO DE UM ITERATOR QUE CIRCULA PELOS VÁRIOS CAMPOS
        //Nao se pode editar id e login
        Person p2 = getPerson(p.getLogin());
        String ps = "UPDATE User SET";
        if(!p.getAddress().equals(p2.getAddress()))
            ps+=" address = '" + p.getAddress() + "'";
        if(!p.getCity().equals(p2.getCity()))
            ps+=" city = '" + p.getCity()+"'";
        if(!p.getCountry().equals(p2.getCountry()))
            ps+=" country = '" + p.getCountry()+"'";
        if(!p.getEmail().equals(p2.getEmail()))
            ps+=" email = '" + p.getEmail()+"'";
        if(!p.getName().equals(p2.getName()))
            ps+=" name = '" + p.getName()+"'";
        if(!p.getPassword().equals(p2.getPassword()))
            ps+=" expires = '" + p.getPassword()+"'";
        if(!p.getPhone().equals(p2.getPhone()))
            ps+=" phonenumber = '" + p.getPhone()+"'";
        if(!p.getPostalcode().equals(p2.getPostalcode()))
            ps+=" postalcode = '" + p.getPostalcode()+"'";
        
        ps+=" WHERE idUser = " + p.id;
        
        try {
            //preparedStatement = (PreparedStatement) con.prepareStatement("UPDATE User SET name='" + name + ",email='" + email + "',expires='" + expires + "' WHERE idUser = " + id);
            preparedStatement = (PreparedStatement) con.prepareStatement(ps);
            preparedStatement.executeUpdate();
            return p;
        } catch (Exception e) {
            System.err.println(e);
            return new Person();
        }
    }
    
    
    
    /************************BOOKS**************************/
    
    private boolean existsBook(String ISBN)
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
        
        Book b = new Book();
        try{
            resultSet = st.executeQuery("select * from User where ISBN='"+ISBN+"';");
            while(resultSet.next())
            {
                b.setAuthor(resultSet.getString("author"));
              
                b.setName(resultSet.getString("title"));
                b.setYear(resultSet.getInt("year"));
                b.setCategory(resultSet.getString("category"));
                b.setNumberOfCopies(resultSet.getInt("numberofcopies"));
                //expires = stringToDate(resultSet.getString("expires"));
                //public Admin(int id, String name, String e_mail, Address address, String username, String password) {
                //Reader(String name,int limit, Date expires, int id, String e_mail, Address address,int doornumber, String username, String password)
                // Book(String isbn, String name, String author, Date year, String category, int number_of_copies, ArrayList<Comment> comments)
                //String isbn, String name, String author, int year, String category, int number_of_copies
                
                //b = new Book(ISBN,title,author,year,cat,ncopies); //,email,addr,doornumber,login,pass);
            }
            
            
        }catch (Exception e) {
            System.err.println(e);
            return b;
        }
        return b;
    }
    
    public Book getBookByTitle(String title)
    {
        Book b = new Book();
        try{
            resultSet = st.executeQuery("select * from User where author='"+b.getAuthor()+"';");
            while(resultSet.next())
            {
                b.setIsbn(resultSet.getString("ISBN"));
                b.setName(resultSet.getString("title"));
                b.setYear(resultSet.getInt("year"));
                b.setCategory(resultSet.getString("category"));
                b.setNumberOfCopies(resultSet.getInt("numberofcopies"));
                //expires = stringToDate(resultSet.getString("expires"));
                //public Admin(int id, String name, String e_mail, Address address, String username, String password) {
                //Reader(String name,int limit, Date expires, int id, String e_mail, Address address,int doornumber, String username, String password)
                // Book(String isbn, String name, String author, Date year, String category, int number_of_copies, ArrayList<Comment> comments)
                //String isbn, String name, String author, int year, String category, int number_of_copies
                
                //b = new Book(ISBN,title,author,year,cat,ncopies); //,email,addr,doornumber,login,pass);
            }
            
            
        }catch (Exception e) {
            System.err.println(e);
            return b;
        }
        return b;
    }
    
    public Book storeBook(Book b)
    {
        if(existsBook(b.getIsbn()))
            return new Book();
        try {
            String insert = "INSERT INTO Book (ISBN,author,title,year,category,numberofcopies) "
                    + "VALUES('" + b.getIsbn() + "','"
                    + b.getAuthor() + "','"
                    + b.getName() + "',"
                    + b.getYear() +",'"
                    + b.getCategory()+ "',"
                    + b.getNumberOfCopies() + ");";
            System.out.println(insert);
            st.execute(insert);
            return b;
            
            
        }catch (Exception e) {
            System.err.println(e);
            return new Book();
        }
        
    }
    
    /************************COMMENTS**************************/
    
    
    /*
     * 
     * idReview INT
     * user_id INT
     * book_ISBN VARCHAR(45)
     * messagebody VARCHAR(1024)
     * rating INT
     * 
     * 
     */
    
    private boolean existsComment(int idReview)
    {
        try {
            resultSet = st.executeQuery("select * from Review where idReview='" + idReview + "';");
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
    
    public Comment storeComment(Comment c)
    {
        if(existsComment(c.getId()))
            return new Comment();
        try
        {
            String insert = "INSERT INTO Review (user_id,book_ISBN,messagebody,rating) "
                    + "VALUES(" + c.getCommenter().getId() + ",'"
                    + c.getBook() + "','"
                    + c.getBody() + "',"
                    + c.getRating() +");";
            System.out.println(insert);
            st.execute(insert);
            return c;
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Comment();
        
    }
    public ArrayList<Comment> getCommentsByBook(String ISBN)
    {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        try
        {
            resultSet = st.executeQuery("select * from Review where book_ISBN='"+ISBN+"';");
            Comment tmp;
            while(resultSet.next())
            {
                tmp = new Comment();
                tmp.setId(resultSet.getInt("idReview"));
                tmp.setBook(resultSet.getString("ISBN"));
                tmp.setCommenter(getReaderById(resultSet.getInt("user_id")));
                tmp.setRating(resultSet.getInt("rating"));
                comments.add(tmp);
            }
            return comments;
           
        } catch(Exception e)
        {
            System.err.println(e);
        }
        return comments;
    }
    
    /************************RESERVATIONS**************************/
    
    

}
