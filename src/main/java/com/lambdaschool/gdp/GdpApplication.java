package com.lambdaschool.gdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class GdpApplication {

    public static GdpList ourGDPList;
    public static void main(String[] args) {
        ourGDPList = new GdpList();
        ApplicationContext ctx = SpringApplication.run(GdpApplication.class, args);

        /*
         in the background spring runs a dispatch servlet that handles all of our routing for us
         so we send it an endpoint and it finds where it goes and runs the proper method. IF it doesnt find one, it has its own method for that.
         lets use ours instead.
         we added ApplicationContext ctx =
        */

        DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
        // remember a bean is an java object (json). if this is spelled wrong theres no error checking for this. get it right every time.
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        // when we dont find an endpoint we will handle it not the dispatcher servlet


    }
}