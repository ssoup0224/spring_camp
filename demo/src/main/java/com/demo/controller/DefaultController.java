package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    // 요청한 URL이 변하지 않음
    // @RequestMapping({ "", "/", "/index"})
    // public String index(@RequestParam int a, @RequestParam int b, Model model) {
    // System.out.println("a: " + a);
    // System.out.println("b: " + b);
    // int result = a + b;
    // model.addAttribute("result", result);
    // return "index";
    // }

    // 요청한 URL을 redirect 하기
    @RequestMapping({ "", "/" })
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String index2() {
        // return "redirect:/";
        return "redirect:/multiple?a=1&b=2";
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
    public String stringConcat(@RequestParam String a, @RequestParam String b, Model model) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        String result = a + b;
        model.addAttribute("result", result);
        return "string";
    }
}
