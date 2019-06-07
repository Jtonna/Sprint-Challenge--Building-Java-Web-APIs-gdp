package com.lambdaschool.gdp.controller;


import com.lambdaschool.gdp.GdpApplication;
import com.lambdaschool.gdp.exception.ResourceNotFoundException;
import com.lambdaschool.gdp.model.GDP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    //localhost:2828/country/{id}
    @GetMapping(value = "/country/{id}", produces = {"application/json"})
    public ResponseEntity<?> getByID(@PathVariable long id){
        logger.info("country/" + id + " has been accessed.");
        GDP rtnGDP;
        if(GdpApplication.ourGDPList.findGDP(x -> (x.getId() == id))== null){
            throw new ResourceNotFoundException("Theres no country with the id of "+ id + ". Check with the Illuminati or an parallel earth.");
        } else {
            rtnGDP = GdpApplication.ourGDPList.findGDP(x -> (x.getId() == id));
        }
        // This is a mess. and hurt my brain trying to understand. I just copied and pasted from dogs and fixed things until IntelliJ quit nagging me that there were errors. Please send help.
        return new ResponseEntity<>(rtnGDP, HttpStatus.OK);
    }

    //localhost:2828/country/stats/median
//    @GetMapping(value = "/country/stats/median")
    // https://forgetcode.com/java/1296-median-calculation

    //localhost:2828/economy/table
    @GetMapping(value = "/economy/table")
    public ModelAndView getEconTable(HttpServletRequest request){
        logger.trace(request.getRequestURI() + " has accessed the super top secret Illumanati Master Access to the worlds GDP");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("gdptable");
        mav.addObject("GdpList", GdpApplication.ourGDPList.gdpList);
        return mav;
    }
}
