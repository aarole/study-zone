package com.aarole.study_zone;

import static android.util.Half.NaN;

public abstract class Item {
    private int id;

    public Item(){
        this.id = (int)NaN;
    }

    public Item(int id){
        this.id = id;
    }
}
