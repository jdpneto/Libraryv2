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
    private int id;
    private ArrayList<Book> books;

    public Reservation() {
        this.start_date = null;
        this.end_date = null;
        this.books = new ArrayList<Book>();
        this.id = -1;
    }

    public Reservation(Date start_date, Date end_date, ArrayList<Book> books, int id) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.books = books;
        this.id = id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Date getEndDate() {
        return end_date;
    }

    public void setEndDate(Date end_date) {
        this.end_date = end_date;
    }

    public Date getStartDate() {
        return start_date;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
