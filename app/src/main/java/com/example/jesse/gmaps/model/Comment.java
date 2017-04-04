package com.example.jesse.gmaps.model;

/**
 * Created by Jesse on 3/30/2017.
 */

public class Comment {
    String initials;
    String commentContent;
    String time;

    public String getInitials() {return initials; }
    public void setInitials(String name) {
        this.initials = initials;
    }

    public String getContent () { return commentContent;}
    public void setContent (String commentContent) {this.commentContent = commentContent; }


    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }



}

