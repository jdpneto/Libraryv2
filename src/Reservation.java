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
    private String book;
    private int user_id;

    public Reservation() {
        this.start_date = null;
        this.end_date = null;
        this.book = "";
        this.id = -1;
        this.user_id = -1;
    }

    public Reservation(Date start_date, Date end_date, String books, int id,int user_id) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.book = book;
        this.id = id;
        this.user_id = user_id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
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
    
}
