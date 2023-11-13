package com.pg.springweb.web.api.rest;

import com.pg.springweb.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public String hello(){
        return  "hello";
    }


    @GetMapping("/restapi")
    public User restapi(@RequestParam(value = "name", defaultValue = " cat")String name){

        User user = new User();
        user.setAge(36);
        user.setName("tom "+name);


        return user;
    }
}
