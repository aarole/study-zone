package com.aarole.studyzone;

import java.util.concurrent.atomic.AtomicInteger;

public class ID {
    private static final AtomicInteger id = new AtomicInteger(0);

    public static int getID(){
        return id.incrementAndGet();
    }
}
