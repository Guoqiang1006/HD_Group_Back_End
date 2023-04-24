package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder({ "rating", "comment", "date"})
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Review {
    private int rating;
    private String comment;
    private Date date;
    public Review(int rating, String comment, Date date) {
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
