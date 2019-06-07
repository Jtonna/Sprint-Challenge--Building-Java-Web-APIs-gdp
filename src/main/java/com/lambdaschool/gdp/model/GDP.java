package com.lambdaschool.gdp.model;

import java.util.concurrent.atomic.AtomicLong;

public class GDP {

    //setting up the data types
    public static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private String gdp;

    public GDP(String name, String gdp) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.gdp = gdp;
    }

    public GDP(GDP toClone) {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.gdp = toClone.getGdp();
    }


}
