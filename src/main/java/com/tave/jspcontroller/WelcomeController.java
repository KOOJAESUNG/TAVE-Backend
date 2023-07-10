package com.tave.jspcontroller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class WelcomeController {

    @RequestMapping("index")
    public String home(){
        System.out.println("hi");
        log.info("home controller");
        return "index";
    }
}
