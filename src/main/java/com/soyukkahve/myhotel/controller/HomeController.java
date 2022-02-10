package com.soyukkahve.myhotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/home")
    public String index() {
        return "Hello";
    }
    @RequestMapping("/home2")
    public String index2() {
        return "Hello";
    }


}
