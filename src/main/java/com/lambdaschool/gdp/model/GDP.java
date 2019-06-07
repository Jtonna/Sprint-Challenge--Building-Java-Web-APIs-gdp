package com.lambdaschool.gdp.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

public class GDP {

    // private static final Logger logger = LoggerFactory.getLogger(GDP.class);
    //setting up the data types
    public static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private String gdp;

}
