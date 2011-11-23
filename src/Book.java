/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
import java.util.*;

public class Book {
    
    private String isbn;
    private String name;
    private String author;
    private int year;
    private String category;
    private int number_of_copies;
    private ArrayList<Comment> comments;
    
    Book()
    {
        this.isbn = "";
        this.name = "";
        this.author = "";
        this.year = -1;
        this.category = "";
        this.number_of_copies = -1;
        this.comments = new ArrayList<Comment>();
    }
    
    Book(String isbn, String name, String author, int year, String category, int number_of_copies)
    {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.category = category;
        this.number_of_copies = number_of_copies;
        this.comments = new ArrayList<Comment>();;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComment(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCopies() {
        return number_of_copies;
    }

    public void setNumberOfCopies(int number_of_copies) {
        this.number_of_copies = number_of_copies;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
