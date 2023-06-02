package com.example.tave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaveApplication.class, args);
    }

//    @Bean
//    RouterFunction<ServerResponse> routerFunction() {
//        return route(GET("/docs"), req ->
//                ServerResponse.temporaryRedirect(URI.create("swagger-ui/index.html")).build());
//    }
}
