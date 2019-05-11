package com.aarole.study_zone;

public class ListItem extends Item {
    private int id;
    private String title;

    public ListItem(){
        super();
        this.title = "UNKNOWN";
    }

    public ListItem(int id, String title){
        super(id);
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
