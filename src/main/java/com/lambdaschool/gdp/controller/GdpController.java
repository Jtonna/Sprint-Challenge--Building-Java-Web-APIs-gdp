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
        // This should sort by name a-z
        return new ResponseEntity<>(GdpApplication.ourGDPList.gdpList, HttpStatus.OK);
    }

    // localhost:2828/economy
    @GetMapping(value = "/economy", produces = {"application/json"})
    public  ResponseEntity<?> getCountriesByGDP(){
        logger.info("/economy was accessed.");
        GdpApplication.ourGDPList.gdpList.sort((x1, x2) -> {
            int placeholder1 = Integer.parseInt(x1.getGdp());
            int placeholder2 = Integer.parseInt(x2.getGdp());
            return placeholder2 - placeholder1 ;
        });
        //this should sort economies by highest GDP ot lowest GDP
        return new ResponseEntity<>(GdpApplication.ourGDPList.gdpList, HttpStatus.OK);
    }


}
