package com.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserPageController {
    @RequestMapping("/${page}")
    public String page(@PathVariable String page) {
        return "user/" + page;
    }

    @RequestMapping("/${page}/{id}")
    public String page2(@PathVariable String page, @PathVariable Long id) {
        return "user/" + page;
    }
}
