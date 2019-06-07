package com.lambdaschool.gdp.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

public class GDP {

    private static final Logger logger = new LoggerFactory.getLogger(GDP.class);
    //setting up the data types
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private String gdp;

    public GDP(String name, String gdp) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.gdp = gdp;

        logger.info("We created a country named: " + this.name );
        logger.debug("Im 99.9999999% sure we created a country with the the id of " + this.id );
    }

    public GDP(GDP toClone) {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.gdp = toClone.getGdp();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    @Override
    public String toString() {
        return "GDP{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gdp='" + gdp + '\'' +
                '}';
    }
}
