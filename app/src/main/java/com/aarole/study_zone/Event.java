package com.aarole.study_zone;

public class Event extends Item {
    private int id;
    private String title;

    public Event(){
        super();
        this.title = "UNKNOWN";
    }

    public Event(int id, String title){
        super(id);
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
