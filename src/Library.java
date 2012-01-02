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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.*;
import java.math.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library implements Subject, Observer {

    private Connection con;
    private Statement st;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    /*******OBJSERVER STATE AND SUBJECTS************/
    ArrayList<Observer> observers = new ArrayList<Observer>();
    ArrayList<Stat> subjectState = new ArrayList<Stat>();
    /******************PROXY*********************/
    Log adminlog;
    Log librarianlog;

    public Library() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/library?user=root&password=qwerty");
            st = (Statement) con.createStatement();
            resultSet = null;
            preparedStatement = null;


            //**************OBSERVERS***************//
            attach(new ImageObserver(this));
            attach(new PdfObserver(this));
            attach(this);

            /********PROXY*******/
            librarianlog = new LogProxy("librarian.log");
            adminlog = new LogProxy("admin.log");

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
    public String getMd5(String pass) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes(), 0, pass.length());
            return new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "empty";
    }

    public Vector<String> expiredReservations() {
        Vector<String> expired_reservations =  new Vector <String>();
        Date actual = new Date();
        List<Reservation> reservation = getAllReservations();
        ListIterator<Reservation> iter = new ListIterator(reservation);
        Reservation r;
        if (!iter.IsDone()) {
            r = iter.First();
            if(actual.after(r.getEnd_date())){
                expired_reservations.add("id: "+r.getId()+"  title: "+getBookByISBN(r.getBook_isbn()).getName()+"  reader: "+getReaderById(r.getUser_id()).getLogin());
            }
            while (!iter.IsDone()) {
                r = iter.Next();
                if(actual.after(r.getEnd_date())){
                    expired_reservations.add("id: "+r.getId()+"  title: "+getBookByISBN(r.getBook_isbn()).getName()+"  reader: "+getReaderById(r.getUser_id()).getLogin());
                }
            }
        }


        return expired_reservations;
    }
    
     public Vector<String> expiringReservations(long interval) {
        Vector<String> expiring_reservations =  new Vector <String>();
        Date actual = new Date();
        //get time in ms
        long interval_in_ms = interval * 24 * 60 * 60 * 1000;

        List<Reservation> reservations = getAllReservations();
        ListIterator<Reservation> iter = new ListIterator(reservations);
        Reservation r;
        if (!iter.IsDone()) {
            r = iter.First();
            if (!actual.after(r.getEnd_date()) && (r.getEnd_date().getTime() - actual.getTime()) < interval_in_ms) {
                expiring_reservations.add("id: "+r.getId()+"  title: "+getBookByISBN(r.getBook_isbn()).getName()+"  reader: "+getReaderById(r.getUser_id()).getLogin());
            }
            while (!iter.IsDone()) {
                r = iter.Next();
                if (!actual.after(r.getEnd_date()) && (r.getEnd_date().getTime() - actual.getTime()) < interval_in_ms) {
                    expiring_reservations.add("id: "+r.getId()+"  title: "+getBookByISBN(r.getBook_isbn()).getName()+"  reader: "+getReaderById(r.getUser_id()).getLogin());
                }

            }

        }

        return expiring_reservations;
    }
    
    /* Alterada para devolver Vector <String>
    public ArrayList<Reservation> expiredReservations() {
        ArrayList<Reservation> expired_reservations = new ArrayList<Reservation>();
        Date actual = new Date();
        List<Reservation> reservation = getAllReservations();
        ListIterator<Reservation> iter = new ListIterator(reservation);

        if (!iter.IsDone()) {
            expired_reservations.add(iter.First());
            while (!iter.IsDone()) {
                expired_reservations.add(iter.Next());
            }
        }


        return expired_reservations;
    }

    public ArrayList<Reservation> expiringReservations(long interval) {
        ArrayList<Reservation> expiring_reservations = new ArrayList<Reservation>();
        Date actual = new Date();
        //get time in ms
        long interval_in_ms = interval * 24 * 60 * 60 * 1000;

        List<Reservation> reservations = getAllReservations();
        ListIterator<Reservation> iter = new ListIterator(reservations);
        if (!iter.IsDone()) {
            expiring_reservations.add(iter.First());
            while (!iter.IsDone()) {
                Reservation reservation = iter.Next();
                if (actual.after(reservation.getEnd_date()) && (reservation.getEnd_date().getTime() - actual.getTime()) < interval_in_ms) {
                    expiring_reservations.add(reservation);
                }

            }

        }

        return expiring_reservations;
    }*/

    public ArrayList<Stat> generateStats() {
        ArrayList<Stat> stats = new ArrayList<Stat>();
        String tmp;
        int total = 0;
        try {
            resultSet = st.executeQuery("select category from Book;");
            while (resultSet.next()) {
                total++;
                Book b = new Book();
                tmp = resultSet.getString("category");
                int i = exists(stats, tmp);
                if (i >= 0) {
                    stats.get(i).addOne();
                } else {
                    stats.add(new Stat(tmp, 1));
                }
                //resultSet.getString("category");
            }

            for (Stat s : stats) {
                System.out.println((s.getValue() * 100) / total);
                s.setValue(Math.round((s.getValue() * 100) / total));
            }
            int offset = 0;
            for (Stat s : stats) {
                offset += s.getValue();
            }

            offset = (100 - offset);
            stats.get(0).setValue(stats.get(0).getValue() + offset);


        } catch (Exception e) {
            System.err.println(e);
        }

        return stats;
    }

    private int exists(ArrayList<Stat> tmp, String type) {
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).getType().equals(type)) {
                return i;
            }
        }
        return -1;
    }

    //just because I sometipes use toMd5
    public String toMd5(String pass) {
        return getMd5(pass);
    }

    /***************ADDRESS******************
     *
     * NOT NEEDED IN THE NEW DB SCHEME
     *
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
    public Date stringToDate(String d) {
        Date da = null;
        try {
            da = new SimpleDateFormat("dd/MM/yyyy").parse(d);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return da;


    }

    public String datetoString(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(d);
        return date;
    }

    public int[] getPersonType(Person p) {
        int[] type = new int[3];


        try {
            resultSet = st.executeQuery("select adminaccess,readeraccess,librarianaccess from User where login='" + p.getLogin() + "';");
            while (resultSet.next()) {
                type[0] = resultSet.getInt("adminaccess");
                type[1] = resultSet.getInt("readeraccess");
                type[2] = resultSet.getInt("librarianaccess");
            }
            return type;
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;

    }

    public int[] getPersonTypeById(int id) {
        int[] type = new int[3];


        try {
            resultSet = st.executeQuery("select adminaccess,readeraccess,librarianaccess from User where idUser=" + id + ";");
            while (resultSet.next()) {
                type[0] = resultSet.getInt("adminaccess");
                type[1] = resultSet.getInt("readeraccess");
                type[2] = resultSet.getInt("librarianaccess");
            }
            return type;
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;

    }

    public String getPersonExpiresById(int id) {
        String expires = "";


        try {
            resultSet = st.executeQuery("select expires from User where idUser=" + id + ";");
            while (resultSet.next()) {
                expires = resultSet.getString("expires");
            }
            return expires;
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        return expires;

    }

    public int getPersonLimitById(int id) {
        int limit = -1;


        try {
            resultSet = st.executeQuery("select booklimit from User where idUser=" + id + ";");
            while (resultSet.next()) {
                limit = resultSet.getInt("booklimit");
            }
            return limit;
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
        return limit;

    }

    //    public int checkLogin(String login, String pass)
    //if returned object equals the sent one, then
    //it is an invalid login
    //Every method but this one will recieve an already hashed password
    public Person checkLogin(Person p) {
        //String login;
        String hash;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + p.getLogin() + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                p.setId(-2);
                hash = resultSet.getString("md5_pass");

                if (hash.equals(getMd5(p.getPassword()))) {

                    Person pb = new Person();
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
                    //System.out.println("Person: "+ pb.toString());
                    addLineToLog("admin.log", "User " + pb.getLogin() + " logged in");
                    return pb;//resultSet.getByte("type");
                } else {
                    return p;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            return p;
        }
        //nao existe utilizador
        return p;
    }

    //person storage helper
    private boolean existsPerson(String login) {
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

    public Person getPerson(String login) {
        Person p = new Person();
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                Person pb = new Person();
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

                return pb;//resultSet.getByte("type");

            }
        } catch (Exception e) {
            System.err.println(e);
            return p;
        }
        //nao existe utilizador
        return p;
    }

    public Admin getAdmin(String login) {
        Admin a = new Admin();
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            System.out.println("query: " + "select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                Person pb = new Person();
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


                /*******BuilderPattern******/
                AdminBuilder ab = new AdminBuilder();
                Director d = new Director(ab);
                d.Construct(pb, getPersonTypeById(pb.getId()), "UNLIMITED", 0);

                return ab.getResult();

            }
        } catch (Exception e) {
            System.err.println(e);
            return a;
        }
        //nao existe utilizador
        return a;
    }

    public Reader getReader(String login) {
        Reader r = new Reader();
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                Person pb = new Person();
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

                /*******BuilderPattern******/
                ReaderBuilder rb = new ReaderBuilder();
                Director d = new Director(rb);
                d.Construct(pb, getPersonTypeById(pb.getId()), getPersonExpiresById(pb.getId()), getPersonLimitById(pb.getId()));

                return rb.getResult();


            }
        } catch (Exception e) {
            System.err.println(e);
            return r;
        }
        //nao existe utilizador
        return r;
    }

    public Reader getReaderById(int id) {
        Reader r = new Reader();
        
        
        try{
            
            
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where idUser=" + id + ";");
            
            while (resultSet.next()) {
                Person pb = new Person();
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

                /*******BuilderPattern******/
                ReaderBuilder rb = new ReaderBuilder();
                Director d = new Director(rb);
                d.Construct(pb, getPersonTypeById(pb.getId()), getPersonExpiresById(pb.getId()), getPersonLimitById(pb.getId()));

                return rb.getResult();


            }
        } catch (Exception e) {
            System.err.println(e);
            return r;
        }
        //nao existe utilizador
        return r;
    }

    public Librarian getLibrarian(String login) {
        Librarian l = new Librarian();
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where login='" + login + "';");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                Person pb = new Person();
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

                /*******BuilderPattern******/
                LibrarianBuilder lb = new LibrarianBuilder();
                Director d = new Director(lb);
                d.Construct(pb, getPersonTypeById(pb.getId()), getPersonExpiresById(pb.getId()), getPersonLimitById(pb.getId()));

                return lb.getResult();


                //return pb.Build();//resultSet.getByte("type");

            }
        } catch (Exception e) {
            System.err.println(e);
            return l;
        }
        //nao existe utilizador
        return l;
    }

    public Librarian storeLibrarian(Librarian l) {
        if (existsPerson(l.getLogin())) {
            return l;
        }
        try {
            int[] type = l.getType();
            String insert = "INSERT INTO User (name,login,email,md5_pass,expires,address,postalcode,city,country,adminaccess,readeraccess,librarianaccess,phonenumber) "
                    + "VALUES('"
                    + l.getName() + "','"
                    + l.getLogin() + "','"
                    + l.getEmail() + "','"
                    + toMd5(l.getPassword()) + "','"
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
            addLineToLog("admin.log", "Librarian " + l.getLogin() + " added!");
            return getLibrarian(l.getLogin());


        } catch (Exception e) {
            System.err.println(e);
            return l;
        }
    }

    public Librarian getLibrarianById(int id) {
        Librarian l = new Librarian();
        //LibrarianBuilder pb;
        try {
            //Vai a base de dados confirmar o login e a password...
            resultSet = st.executeQuery("select * from User where idUser=" + id + ";");
            //-1 -> existe mas a pass está mal
            while (resultSet.next()) {
                Person pb = new Person();
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

                /*******BuilderPattern******/
                LibrarianBuilder lb = new LibrarianBuilder();
                Director d = new Director(lb);
                d.Construct(pb, getPersonTypeById(pb.getId()), getPersonExpiresById(pb.getId()), getPersonLimitById(pb.getId()));

                return lb.getResult();


                //return pb.Build();//resultSet.getByte("type");

            }
        } catch (Exception e) {
            System.err.println(e);
            return l;
        }
        //nao existe utilizador
        return l;
    }

    public Reader storeReader(Reader r) {
        if (existsPerson(r.getLogin())) {
            return r;
        }
        try {
            int[] type = r.getType();
            String insert = "INSERT INTO User (name,login,email,md5_pass,expires,address,postalcode,city,country,adminaccess,readeraccess,librarianaccess,phonenumber,booklimit) "
                    + "VALUES('"
                    + r.getName() + "','"
                    + r.getLogin() + "','"
                    + r.getEmail() + "','"
                    + toMd5(r.getPassword()) + "','"
                    + r.getExpires() + "','"
                    + r.getAddress() + "', '"
                    + r.getPostalcode() + "', '"
                    + r.getCity() + "', '"
                    + r.getCountry() + "', "
                    + type[0] + ", "
                    + type[1] + ", "
                    + type[2] + ", '"
                    + r.getPhone() + "', "
                    + r.getLimit() + ");";
            System.out.println(insert);
            st.execute(insert);
            addLineToLog("admin.log", "Reader " + r.getLogin() + " added!");
            addLineToLog("librarian.log", "Reader " + r.getLogin() + " added!");
            return getReader(r.getLogin());


        } catch (Exception e) {
            System.err.println(e);
            return r;
        }

    }

    public Admin storeAdmin(Admin a) {
        if (existsPerson(a.getLogin())) {
            return a;
        }
        try {
            int[] type = a.getType();
            String insert = "INSERT INTO User (name,login,email,md5_pass,address,postalcode,city,country,adminaccess,readeraccess,librarianaccess,phonenumber) "
                    + "VALUES('"
                    + a.getName() + "','"
                    + a.getLogin() + "','"
                    + a.getEmail() + "','"
                    + toMd5(a.getPassword()) + "','"
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
            addLineToLog("admin.log", "Admin " + a.getLogin() + " added!");
            return getAdmin(a.getLogin());


        } catch (Exception e) {
            System.err.println(e);
            return a;
        }
    }

    public Vector<String> getReaders() {
        Vector<String> a = new Vector<String>();

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

    public Vector<String> getAdmins() {
        Vector<String> a = new Vector<String>();
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

    public Vector<String> getLibrarians() {
        Vector<String> a = new Vector<String>();
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

    public Vector<String> searchUser(String login, int[] type) throws SQLException {
        Vector<String> vector = new Vector<String>();
        //Person p;
        String p, permissions = "";
        if (type[0] == 1) {
            permissions = permissions.concat(" AND adminaccess = 1");
        }
        if (type[1] == 1) {
            permissions = permissions.concat(" AND readeraccess = 1");
        }
        if (type[2] == 1) {
            permissions = permissions.concat(" AND librarianaccess = 1");
        }
        try {
            resultSet = st.executeQuery("SELECT * FROM User WHERE login LIKE '%" + login + "%' " + permissions + ";");
            while (resultSet.next()) {
                vector.add(resultSet.getString("login"));
                /*p = new Person();
                 * p.setId(resultSet.getInt("idUser"));
                 * p.setName(resultSet.getString("name"));
                 * p.setLogin(resultSet.getString("login"));
                 * //p.setPassword(resultSet.getString("password"));
                 * p.setEmail(resultSet.getString("email"));
                 * p.setAddress(resultSet.getString("address"));
                 * p.setPostalcode(resultSet.getString("postalcode"));
                 * p.setCity(resultSet.getString("city"));
                 * p.setCountry(resultSet.getString("country"));
                 * p.setPhone(resultSet.getString("phonenumber"));
                 * int [] type = new int [3];
                 * type[0] = resultSet.getInt("adminaccess");
                 * type[1] = resultSet.getInt("readeraccess");
                 * type[2] = resultSet.getInt("librarianaccess");
                 * p.setType(type);
                 * vector.add(p);*/
            }
            return vector;
        } catch (Exception e) {
            System.err.println(e);
        }
        return vector;
    }

    public boolean removeUser(String id) throws SQLException {
        Reader p = getReaderById(Integer.parseInt(id));
        preparedStatement = (PreparedStatement) con.prepareStatement("DELETE FROM User WHERE idUser = " + id);
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            //return new Person();
            addLineToLog("admin.log", "User " + p.getLogin() + " removed!");
            return true;
        } else {
            // return p;
            return false;
        }
    }

    public Person editUser(EditPersonObject to) {
        //TODO: POSSIVEL IMPLEMENTACAO DE UM ITERATOR QUE CIRCULA PELOS VÁRIOS CAMPOS
        //Nao se pode editar id e login
        //Person p2 = getPerson(p.getLogin());
        Person p = to.getP();
        String expires = to.getExpires();
        int limit = to.getLimit();
        
        addLineToLog("admin.log", "User " + p.getLogin() + " edited!");
        addLineToLog("librarian.log", "User " + p.getLogin() + " edited!");
        String ps = "UPDATE User SET address = '" + p.getAddress() + "',"
                + " city = '" + p.getCity() + "',"
                + " country = '" + p.getCountry() + "',"
                + " email = '" + p.getEmail() + "',"
                + " name = '" + p.getName() + "',"
                + " md5_pass = '" + p.getPassword() + "',"
                + " phonenumber = '" + p.getPhone() + "',"
                + " postalcode = '" + p.getPostalcode() + "'";
        if (expires != null) {
            ps += ", expires = '" + expires + "'";
        }
        if (limit != -1) {
            ps += ", booklimit = " + limit;
        }

        ps += " WHERE idUser = " + p.id;

        try {
            //preparedStatement = (PreparedStatement) con.prepareStatement("UPDATE User SET name='" + name + ",email='" + email + "',expires='" + expires + "' WHERE idUser = " + id);
            System.out.println(ps);
            preparedStatement = (PreparedStatement) con.prepareStatement(ps);
            preparedStatement.executeUpdate();
            return p;
        } catch (Exception e) {
            System.err.println(e);
            return new Person();
        }
    }

    /************************BOOKS**************************/
    private boolean existsBook(String ISBN) {
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
    
    

    public Vector<String> getBookListByTitle(String title) {
        Vector<String> v = new Vector<String>();
        try {
            resultSet = st.executeQuery("select * from Book where title LIKE '%" + title + "%';");
            while (resultSet.next()) {
                v.add(resultSet.getString("title"));
            }
        } catch (Exception e) {
            System.err.println(e);
            return v;
        }
        return v;
    }

    public Book getBookByISBN(String ISBN) {

        Book b = new Book();
        try {
            resultSet = st.executeQuery("select * from Book where ISBN='" + ISBN + "';");
            while (resultSet.next()) {
                b.setAuthor(resultSet.getString("author"));
                b.setIsbn(ISBN);
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


        } catch (Exception e) {
            System.err.println(e);
            return b;
        }
        return b;
    }

    public Book getBookByTitle(String title) {
        Book b = new Book();
        try {
            resultSet = st.executeQuery("select * from Book where title='" + title + "';");
            while (resultSet.next()) {
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


        } catch (Exception e) {
            System.err.println("1:" + e);
            return b;
        }
        return b;
    }

    public Book storeBook(Book b) {
        if (existsBook(b.getIsbn())) {
            return new Book();
        }
        try {
            String insert = "INSERT INTO Book (ISBN,author,title,year,category,numberofcopies) "
                    + "VALUES('" + b.getIsbn() + "','"
                    + b.getAuthor() + "','"
                    + b.getName() + "',"
                    + b.getYear() + ",'"
                    + b.getCategory() + "',"
                    + b.getNumberOfCopies() + ");";
            System.out.println(insert);
            st.execute(insert);
            addLineToLog("librarian.log", " Book " + b.getName() + " added!");
            subjectState = generateStats();

            Notify();
            return b;


        } catch (Exception e) {
            System.err.println(e);
            return new Book();
        }

    }

    public boolean removeBook(String isbn) throws SQLException {
        Book b = getBookByISBN(isbn);
        preparedStatement = (PreparedStatement) con.prepareStatement("DELETE FROM Book WHERE ISBN = '" + isbn + "';");
        preparedStatement.executeUpdate();
        if (preparedStatement != null) {
            //return new Person();
            addLineToLog("librarian.log", " Book " + b.getName() + " deleted!");
            subjectState = generateStats();
            Notify();
            return true;
        } else {
            // return p;
            return false;
        }
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> ret = new ArrayList<Book>();

        try {
            resultSet = st.executeQuery("select * from Book;");
            while (resultSet.next()) {
                Book b = new Book();
                b.setIsbn(resultSet.getString("ISBN"));
                b.setName(resultSet.getString("title"));
                b.setYear(resultSet.getInt("year"));
                b.setCategory(resultSet.getString("category"));
                b.setNumberOfCopies(resultSet.getInt("numberofcopies"));
                ret.add(b);

            }
            return ret;



        } catch (Exception e) {
            System.err.println(e);
        }
        return ret;
    }

    public Vector<String> getAllBookTitles() {
        Vector<String> ret = new Vector<String>();

        try {
            resultSet = st.executeQuery("select * from Book;");
            while (resultSet.next()) {
                ret.add(resultSet.getString("title"));
            }
            return ret;
        } catch (Exception e) {
            System.err.println(e);
        }
        return ret;
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
    private boolean existsComment(int idReview) {
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

    public Comment storeComment(Comment c) {
        if (existsComment(c.getId())) {
            return new Comment();
        }
        try {
            String insert = "INSERT INTO Review (username,book_ISBN,messagebody,book_r) "
                    + "VALUES('" + c.getCommenter() + "','"
                    + c.getBook() + "','"
                    + c.getBody() + "',"
                    + c.getRating() + ");";
            System.out.println(insert);
            st.execute(insert);
            addLineToLog("librarian.log", " Comment added to book " + c.getBook());
            return c;
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Comment();

    }

    public ArrayList<Comment> getCommentsByBook(String ISBN) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        try {
            //System.out.println("select rating from Review where book_ISBN='" + ISBN + "';");
            resultSet = st.executeQuery("select * from Review where book_ISBN='" + ISBN + "';");
            Comment tmp;
            //System.out.print(resultSet);
            while (resultSet.next()) {
                
                //Reader r = getReaderById(readerid);
                tmp = new Comment();
                tmp.setId(resultSet.getInt("idReview"));
                tmp.setBook(resultSet.getString("book_ISBN"));
                tmp.setCommenter(resultSet.getString("username"));
                tmp.setBody(resultSet.getString("messagebody"));
                tmp.setRating(resultSet.getInt("book_r"));
                //tmp.setCommenter();
                
                comments.add(tmp);
            }
            return comments;

        } catch (Exception e) {
            System.err.println(e);
        }
        return comments;
    }
    
    public double getBookRatingByISBN(String ISBN)
    {
        double avg = 0.0;
        ArrayList<Comment> comments = getCommentsByBook(ISBN);
        for(Comment c : comments)
        {
            avg+=c.getRating();
        }
        if(avg != 0.0)
            avg = avg/comments.size();
        
        return avg;
    }
    
    public Object[] getCommentsListByBook(String ISBN)
    {
        ArrayList<Comment> comments = getCommentsByBook(ISBN);
        ArrayList<String> ret = new ArrayList<String>();
        
        ret.add("Comments\n\n");
        
        
        for(Comment c : comments)
        {
            ret.add("Author: "+c.getCommenter());
            ret.add("Rating: "+c.getRating());
            ret.add("Review: "+c.getBody());
            ret.add("\n");
            ret.add("---------------------------");
            ret.add("\n");
        }
        return ret.toArray();
    }

    /************************RESERVATIONS**************************/
    private boolean existsReservation(int idReservation) {
        try {
            resultSet = st.executeQuery("select * from Reservation where idReservation='" + idReservation + "';");
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public Reservation getReservation(String idReservation) {
        try {
            resultSet = st.executeQuery("select * from Reservation where idReservation='" + idReservation + "';");
            Reservation tmp;
            while (resultSet.next()) {
                System.out.println(idReservation+","+resultSet.getInt("idReservation"));
                tmp = new Reservation();
                tmp.setId(resultSet.getInt("idReservation"));
                tmp.setStart_date(stringToDate(resultSet.getString("startdate")));
                tmp.setEnd_date(stringToDate(resultSet.getString("enddate")));
                tmp.setUser_id(resultSet.getInt("user"));
                tmp.setBook_isbn(resultSet.getString("book"));
                tmp.setnumber_of_copies(resultSet.getInt("nbooks"));
                return tmp;
            }
            return new Reservation();
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Reservation();
    }

    public Reservation storeReservation(Reservation r) {
        /*if (existsReservation(r.getId())) {
         * return new Reservation();
         * }*/
        try {
            resultSet = st.executeQuery("select * from Book where isbn = '" + r.getBook_isbn() + "';");
            Book tmp = new Book();
            while (resultSet.next()) {
                tmp.setAuthor(resultSet.getString("author"));
                tmp.setName(resultSet.getString("title"));
                tmp.setIsbn(resultSet.getString("isbn"));
                tmp.setYear(resultSet.getInt("year"));
                tmp.setCategory(resultSet.getString("category"));
                tmp.setNumberOfCopies(resultSet.getInt("numberofcopies"));
            }
            if(r.getNumber_of_copies() > tmp.getNumberOfCopies()){
                return new Reservation();
            }
            else{
                String insert = "INSERT INTO Reservation (startdate,enddate,user,book,nbooks) "
                        + "VALUES('" + datetoString(r.getStart_date()) + "','"
                        + datetoString(r.getEnd_date()) + "','"
                        + r.getUser_id() + "','"
                        + r.getBook_isbn() + "','"
                        + r.getNumber_of_copies() + "');";
                System.out.println(insert);
                st.execute(insert);
                addLineToLog("librarian.log", r.getBook_isbn() + " reserved!");
                            
                String ps = "UPDATE Book SET author = '" + tmp.getAuthor() + "',"
                + " title = '" + tmp.getName() + "',"
                + " year = '" + tmp.getYear() + "',"
                + " category = '" + tmp.getCategory() + "',"
                + " numberofcopies = '" + (tmp.getNumberOfCopies()-r.getNumber_of_copies()) + "'";
                ps += " WHERE isbn = '" + tmp.getIsbn() +"';";

                System.out.println(ps);
                preparedStatement = (PreparedStatement) con.prepareStatement(ps);
                preparedStatement.executeUpdate();
                return r;
                
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Reservation();
    }
    
    public Reservation editReservation(Reservation r) {
        /*if (existsReservation(r.getId())) {
         * return new Reservation();
         * }*/
        try {
            resultSet = st.executeQuery("select * from Reservation where idReservation = '" + r.getId() + "';");
            Reservation stored = new Reservation();
            while (resultSet.next()) {
                stored.setBook_isbn(resultSet.getString("book"));
                stored.setUser_id(resultSet.getInt("user"));
                stored.setnumber_of_copies(resultSet.getInt("nbooks"));
                stored.setStart_date(stringToDate(resultSet.getString("startdate")));
                stored.setEnd_date(stringToDate(resultSet.getString("enddate")));
            }
            resultSet = st.executeQuery("select * from Book where ISBN = '" + r.getBook_isbn() + "';");
            Book tmp = new Book();
            while (resultSet.next()) {
                tmp.setAuthor(resultSet.getString("author"));
                tmp.setName(resultSet.getString("title"));
                tmp.setIsbn(resultSet.getString("ISBN"));
                tmp.setYear(resultSet.getInt("year"));
                tmp.setCategory(resultSet.getString("category"));
                tmp.setNumberOfCopies(resultSet.getInt("numberofcopies"));
            }
            if(stored.getNumber_of_copies() == r.getNumber_of_copies()){
                return new Reservation();
            }
            else{
                String update_reservation = "UPDATE Reservation SET nbooks = '" + r.getNumber_of_copies() + "',"
                        + "enddate = '" + datetoString(r.getEnd_date()) + "'"
                        + " WHERE idReservation = '" + r.getId() +"';";
                System.out.println(update_reservation);
                preparedStatement = (PreparedStatement) con.prepareStatement(update_reservation);
                preparedStatement.executeUpdate();
                addLineToLog("librarian.log", r.getBook_isbn() + " reservation edited!");
                            
                String ps = "UPDATE Book SET numberofcopies = '" + (tmp.getNumberOfCopies()+stored.getNumber_of_copies()-r.getNumber_of_copies()) + "'"
                        + " WHERE ISBN = '" + tmp.getIsbn() +"';";

                System.out.println(ps);
                preparedStatement = (PreparedStatement) con.prepareStatement(ps);
                preparedStatement.executeUpdate();
                return r;
                
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return new Reservation();
    }

    public boolean removeReservation(String id){
        try {
            Reservation r = getReservation(id);
            System.out.println(r.getBook_isbn());
            
            Book b = getBookByISBN(r.getBook_isbn());
            System.out.println("--"+b.getIsbn());
            preparedStatement = (PreparedStatement) con.prepareStatement("DELETE FROM Reservation WHERE idReservation = '" + id + "';");
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                //return new Person();
                String ps = "UPDATE Book SET numberofcopies = '" + (b.getNumberOfCopies()+r.getNumber_of_copies()) + "'"
                + " WHERE ISBN = '" + b.getIsbn() +"';";
                System.out.println(ps);
                preparedStatement = (PreparedStatement) con.prepareStatement(ps);
                preparedStatement.executeUpdate();
                addLineToLog("librarian.log", r.getBook_isbn() + " returned!");
                return true;
            } else {
                // return p;
                return false;
            }
        } catch (SQLException ex) {
           // Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Vector<String> getReservationsList() {
        Vector<String> reservations = new Vector<String>();
        try {
            resultSet = st.executeQuery("select * from Reservation ;");
            Reservation tmp;
            int i = 0;
            while (resultSet.next()) {
                tmp = new Reservation();
                tmp.setId(resultSet.getInt("idReservation"));
                tmp.setStart_date(stringToDate(resultSet.getString("startdate")));
                tmp.setEnd_date(stringToDate(resultSet.getString("enddate")));
                tmp.setUser_id(resultSet.getInt("user"));
                tmp.setBook_isbn(resultSet.getString("book"));
                reservations.add(tmp.getId() + " : " + getReaderById(tmp.getUser_id()).getLogin() + " >>> " + tmp.getBook_isbn());
                System.out.println(reservations.get(i));
                i++;
            }
            return reservations;

        } catch (Exception e) {
            System.err.println(e);
        }
        return reservations;
    }

    public Vector<String> getReservationsByUserLogin(String login) {
        Vector<String> reservations = new Vector<String>();
        Vector<Person> results = new Vector<Person>();
        try {
            int[] type = {0, 1, 0};
            Vector<String> vector = searchUser(login, type);
            for (int i = 0; i < vector.size(); i++) {
                results.add(getPerson(vector.get(i)));
                int id = results.get(i).getId();
                System.out.println(id + " : " + results.get(i).getLogin());
                resultSet = st.executeQuery("select * from Reservation where user =" + id + ";");
                Reservation tmp;
                while (resultSet.next()) {
                    tmp = new Reservation();
                    tmp.setId(resultSet.getInt("idReservation"));
                    tmp.setStart_date(stringToDate(resultSet.getString("startdate")));
                    tmp.setEnd_date(stringToDate(resultSet.getString("enddate")));
                    tmp.setUser_id(id);
                    tmp.setBook_isbn(resultSet.getString("book"));
                    reservations.add(tmp.getId() + " : " + getBookByISBN(tmp.getBook_isbn()).getName());
                }
            }
            return reservations;

        } catch (Exception e) {
            System.err.println(e);
        }
        return reservations;
    }

    public ArrayList<Reservation> getReservationsByUserId(int id) {
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        try {

            resultSet = st.executeQuery("select * from Reservation where user ='" + id + "';");
            Reservation tmp;
            while (resultSet.next()) {
                tmp = new Reservation();
                tmp.setId(resultSet.getInt("idReservation"));
                tmp.setStart_date(stringToDate(resultSet.getString("startdate")));
                tmp.setEnd_date(stringToDate(resultSet.getString("enddate")));
                tmp.setUser_id(id);
                reservations.add(tmp);
            }
            return reservations;

        } catch (Exception e) {
            System.err.println(e);
        }
        return reservations;
    }

//    public ArrayList<Reservation> getAllReservations() {
//        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
//        try {
//            
//            resultSet = st.executeQuery("select * from Reservation;");
//            Reservation tmp;
//            while (resultSet.next()) {
//                tmp = new Reservation();
//                tmp.setId(resultSet.getInt("idReservation"));
//                tmp.setStartDate(stringToDate(resultSet.getString("startdate")));
//                tmp.setEndDate(stringToDate(resultSet.getString("enddate")));
//                tmp.setUser_id(resultSet.getInt("user"));
//                reservations.add(tmp);
//            }
//            return reservations;
//            
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        return reservations;
//    }
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new List<Reservation>();
        try {

            resultSet = st.executeQuery("select * from Reservation;");
            Reservation tmp;
            while (resultSet.next()) {
                tmp = new Reservation();
                tmp.setId(resultSet.getInt("idReservation"));
                tmp.setStart_date(stringToDate(resultSet.getString("startdate")));
                tmp.setEnd_date(stringToDate(resultSet.getString("enddate")));
                tmp.setUser_id(resultSet.getInt("user"));
                tmp.setBook_isbn(resultSet.getString("book"));
                reservations.Append(tmp);
            }
            return reservations;

        } catch (Exception e) {
            System.err.println(e);
        }
        return reservations;
    }

    public void addLineToLog(String filename, String line) {
        if (filename.equals("librarian.log")) {
            librarianlog.addLineToLog(line);
        } else {
            adminlog.addLineToLog(line);
        }
        try {
            Writer output;
            output = new BufferedWriter(new FileWriter(filename, true));
            output.append(line);
            output.append(System.getProperty("line.separator"));
            output.close();
        } catch (IOException ex) {
            //Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**************PROXY PATTERN***********************/
    public String[] loadLibrarianLog() {

        String ret_log = librarianlog.displayLog();
        return ret_log.split(System.getProperty("line.separator"));
    }

    public String[] loadAdminLog() {

        String ret_log = adminlog.displayLog();
        return ret_log.split(System.getProperty("line.separator"));
    }

    /**************OBSERVER PATTERN********************/
    @Override
    public void attach(Observer o) {
        //TODO: Implementar as cenas do subject
        observers.add(o);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Notify() {
        //throw new UnsupportedOperationException("Not supported yet.");
        for (Observer o : observers) {
            o.update();
        }
    }

    @Override
    public ArrayList<Stat> getState() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return subjectState;

    }

    @Override
    public void setState(ArrayList<Stat> state) {
        subjectState = state;

    }

    //observer classes
    @Override
    public void update() {
        subjectState = this.getState();
    }
    //**************SINGLETON*****************
    private static Library _instance = null;

    public static Library Instance() {
        if (_instance == null) {
            _instance = new Library();
        }
        return _instance;
    }
}
