package com.lambdaschool.gdp.controller;


import com.lambdaschool.gdp.GdpApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class GdpController
{
    private static final Logger logger = LoggerFactory.getLogger(GdpController.class);
    // final means we would never change it. we need this line in every file we might want a log from

    // localhost:2828/names
    @GetMapping(value = "/names", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByName(){
        logger.info("/names was accessed.");
        GdpApplication.ourGDPList.gdpList.sort((x1, x2) -> x1.getName().compareToIgnoreCase(x2.getName()));
        // This should sort by name
        return new ResponseEntity<>(GdpApplication.ourGDPList.gdpList, HttpStatus.OK);
    }

    

}
