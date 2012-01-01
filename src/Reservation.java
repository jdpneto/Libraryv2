/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */

import java.util.*;

public class Reservation {
    private Date start_date;
    private Date end_date;
    private int number_of_copies;
    private String book_isbn;
    private int user_id;
    private int id;

    public Reservation() {
        this.start_date = null;
        this.end_date = null;
        this.book_isbn = "";
        this.number_of_copies = -1;
        this.user_id = -1;
    }

    public Reservation(Date start_date, Date end_date, String book, int user_id ,int number_of_copies) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.book_isbn = book;
        this.number_of_copies = number_of_copies;
        this.user_id = user_id;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book) {
        this.book_isbn = book;
    }

    public int getNumber_of_copies() {
        return number_of_copies;
    }

    public void setnumber_of_copies(int number_of_copies) {
        this.number_of_copies = number_of_copies;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reservation{" + "start_date=" + start_date + ", end_date=" + end_date + ", number_of_copies=" + number_of_copies + ", book_isbn=" + book_isbn + ", user_id=" + user_id + ", id=" + id + '}';
    }
    
    
    
}
