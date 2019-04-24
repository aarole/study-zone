package com.aarole.studyzone;

public class Reminder extends Event {
    private int id;
    private String title;
    private String start;
    private String end;

    public Reminder(){
        super();
        this.start = "UNKNOWN";
        this.end= "UNKNOWN";
    }

    public Reminder(int id, String title, String start, String end){
        super(id, title);
        this.start = start;
        this.end = end;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
