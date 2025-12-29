package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @RequestMapping("/assignment")
    public String assignment1() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
        return "완료";
    }
}
