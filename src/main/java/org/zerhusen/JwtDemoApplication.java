package org.zerhusen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//public class JwtDemoApplication {
//
//    public static void main(String[] args) {
//        TypeOfServer.getOs();
//        SpringApplication.run(JwtDemoApplication.class, args);
//    }
//
//}
public class JwtDemoApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        TypeOfServer.getOs();
        SpringApplication.run(JwtDemoApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(JwtDemoApplication.class);
    }
}
