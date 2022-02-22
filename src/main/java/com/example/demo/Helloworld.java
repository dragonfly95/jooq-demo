package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @RequestMapping("/")
    public String helloworld() {
        return "helloworld";
    }

    @RequestMapping("/helloworld")
    public String helloworld2() {

        String str = "hello world nice to meet you";
        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.println("i = " + s[i]);
        }
        return "helloworld2";
    }
}
