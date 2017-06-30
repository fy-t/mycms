package com.cms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by taifuyu on 17/6/30.
 */
@SpringBootApplication
public class MycmsApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MycmsApplication.class).web(true).run(args);
    }

}
