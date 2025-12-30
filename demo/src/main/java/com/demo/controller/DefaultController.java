package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    @RequestMapping("/index")
    public String index(@RequestParam int a, @RequestParam int b, Model model) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        int result = a + b;
        model.addAttribute("result", result);
        return "index";
    }

    @RequestMapping("/multiple")
    public String multiple(@RequestParam int a, @RequestParam int b, Model model) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        int result = a * b;
        model.addAttribute("result", result);
        return "multiple";
    }

    @RequestMapping("/string")
    public String multiple(@RequestParam String a, @RequestParam String b, Model model) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        String result = a + b;
        model.addAttribute("result", result);
        return "string";
    }
}
