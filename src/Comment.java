/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jlnabais
 */
public class Comment {
    private Reader commenter;
    private int rating;
    private String body;

    public Comment() {
        this.commenter = new Reader();
        this.rating = -999999999;
        this.body = body;
    }

    public Comment(Reader commenter, int rating, String body) {
        this.commenter = commenter;
        this.rating = rating;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Reader getCommenter() {
        return commenter;
    }

    public void setCommenter(Reader commenter) {
        this.commenter = commenter;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
