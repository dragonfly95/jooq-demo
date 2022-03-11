package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
public class Helloworld {


    @RequestMapping("/data")
    public MyData getData(HttpServletRequest request, HttpServletResponse response) {

        // 로그인
        // userid, passowrd 빈값 인지 체크
        // password 맞는 앉는지 체크
        // 로그인 해야 볼 수 있는데 세션체크 
        String str = "hello world nice to meet you";
        String[] s = str.split(" ");
        List<String> strings = Arrays.asList(s);

        MyData data = new MyData();
        data.setList(strings);
        int result = data.sum(1, 2);
        return data;
    }

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

        List<String> strings = Arrays.asList(s);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);
        }
        return "helloworld2";
    }
}
