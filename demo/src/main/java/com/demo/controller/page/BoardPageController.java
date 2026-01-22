package com.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardPageController {

    @RequestMapping("/create")
    public String create() {
        return "board/create";
    }

    @RequestMapping("/detail/{id}")
    public String detail() {
        return "board/detail";
    }

    @RequestMapping("/list")
    public String list() {
        return "board/list";
    }
}
