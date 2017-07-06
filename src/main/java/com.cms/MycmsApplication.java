package com.cms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by taifuyu on 17/6/30.
 */
@SpringBootApplication
public class MycmsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MycmsApplication.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MycmsApplication.class).web(true).run(args);
    }

}
