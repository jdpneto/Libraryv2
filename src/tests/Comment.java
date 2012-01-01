package tests;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Comment {
    private int id;
    private String commenter;
    private int rating;
    private String body;
    private String book;

    public Comment() {
        this.id = -1;
        this.commenter = "";
        this.rating = -999999999;
        this.body = "";
        this.book = "";
    }

    public Comment(int id, String commenter, int rating, String body, String book) {
        this.id = id;
        this.commenter = commenter;
        this.rating = rating;
        this.body = body;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
        
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
