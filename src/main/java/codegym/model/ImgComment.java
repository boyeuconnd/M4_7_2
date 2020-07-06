package codegym.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class ImgComment implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String feedback;
    private int point;
    private Timestamp date;
    private int likes;

    public ImgComment() {
    }

    public ImgComment(String author, String feedback, int point, Timestamp date, int likes) {
        this.author = author;
        this.feedback = feedback;
        this.point = point;
        this.date = date;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
