package com.example.simpletodo;

import java.util.Date;

public class EventDate {
    private String text;
    private Date date;
    public EventDate(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public String getText(){
        return this.text;
    }

    public Date getDate(){
        return this.date;
    }

    public void setText(String newText){
        this.text = newText;
    }

    public void setDate(Date newDate){
        this.date = newDate;
    }
}
