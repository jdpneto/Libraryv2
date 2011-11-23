/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */


import java.util.*;


public class Library {
    
    private dataManager dat;
    private String name;
    private ArrayList<Reader> readers;
    private ArrayList<Librarian> librarians;
    private ArrayList<Admin> admins;
    private ArrayList<Book> books;
    private ArrayList<Reservation> reservations;

    public Library() {
        this.dat = new dataManager();
        this.name = "";
        this.readers = new ArrayList<Reader>();
        this.librarians = new ArrayList<Librarian>();
        this.admins = new ArrayList<Admin>();
        this.books = new ArrayList<Book>();
        this.reservations = new ArrayList<Reservation>();
        //init();
        new LoginForm(dat).setVisible(true);
        
    }

    public Library(String name, ArrayList<Reader> readers, ArrayList<Librarian> librarians, ArrayList<Admin> admins, ArrayList<Book> books, ArrayList<Reservation> reservations) {
        this.name = name;
        this.readers = readers;
        this.librarians = librarians;
        this.admins = admins;
        this.books = books;
        this.reservations = reservations;
        //init();
    }
    
    /* public void init(){
     * Disk d = new Disk();
     * this.setReaders(d.load(new Reader(),"readers.dat"));
     * this.setLibrarians((ArrayList<Librarian>)d.load(new Librarian(),"librarians.dat"));
     * this.setAdmins((ArrayList<Admin>)d.load(new Admin(),"admins.dat"));
     * this.setBooks((ArrayList<Book>)d.load(new Book(),"books.dat"));
     * this.setReservations((ArrayList<Reservation>)d.load(new Reservation(),"reservations.dat"));
     * }*/
    
    public void addReader(Reader reader){
        this.readers.add(reader);
        System.out.println("Reader :" + reader.getUsername() + " succesfully added;");
    }
    
    public void removeReader(int id){
        for(Reader reader : this.readers){
            if(reader.getId()==id){
                this.readers.remove(reader);
                System.out.println("Reader :" + reader.getUsername() + " succesfully removed;");
            }
        }
    }
    
    public void addLibrarian(Librarian librarian){
        this.librarians.add(librarian);
        System.out.println("Librian :" + librarian.getUsername() + " succesfully added;");
    }
    
    public void removeLibrarian(int id){
        for(Librarian librarian : this.librarians){
            if(librarian.getId()==id){
                this.librarians.remove(librarian);
                System.out.println("Librarian :" + librarian.getUsername() + " succesfully removed;");
            }
        }
    }

    public void addAdmin(Admin admin){
        this.admins.add(admin);
        System.out.println("Admin :" + admin.getUsername() + " succesfully added;");
    }

    public void removeAdmin(int id){
        for(Admin admin : this.admins){
            if(admin.getId()==id){
                this.admins.remove(admin);
                System.out.println("Admin :" + admin.getUsername() + " succesfully removed;s");
            }
        }
    }
    
    public void addBook(Book book){
        this.books.add(book);
        System.out.println("Book :" + book.getName() + " succefully added;");
    }

    public void removeBook(String isbn){
        for(Book book : this.books){
            if(book.getIsbn().equals(isbn)){
                this.books.remove(book);
                System.out.println("Book :" + book.getName() + " succefully removed;");
            }
        }
    }

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
        System.out.println("Reservation " + reservation.getId() + " succefully added");
    }
    
    public void removeReservation(int id){
        for(Reservation reservation: this.reservations){
            if(reservation.getId() == id){
                this.reservations.remove(reservation);
                System.out.println("Reservation " + reservation.getId() + " succefully removed");
            }
        }
    }

    public ArrayList<Reservation> expiredReservations(){
        ArrayList<Reservation> expired_reservations = new ArrayList<Reservation>();
        Date actual = new Date();
        for(Reservation reservation : this.getReservations()){
            if(reservation.getEndDate().before(actual)){
                expired_reservations.add(reservation);
            }
        }
        return expired_reservations;
    }

    public ArrayList<Reservation> expiringReservations(long interval){
        ArrayList<Reservation> expiring_reservations = new ArrayList<Reservation>();
        Date actual = new Date();
        //get time in ms
        long interval_in_ms = interval*24*60*60*1000;
        for(Reservation reservation : this.getReservations()){
            if(actual.after(reservation.getEndDate()) && (reservation.getEndDate().getTime()-actual.getTime()) < interval_in_ms){
                expiring_reservations.add(reservation);
            }
        }
        return expiring_reservations;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(ArrayList<Librarian> librarians) {
        this.librarians = librarians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(ArrayList<Reader> readers) {
        this.readers = readers;
    }
    
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
