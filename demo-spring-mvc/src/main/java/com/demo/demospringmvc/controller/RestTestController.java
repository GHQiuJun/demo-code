package com.demo.demospringmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: RestTestController
 * @description: Rest Test Controller
 * @author: 60007949
 * @create: 2022-10-11 14:56
 **/
@RestController
public class RestTestController {

    @RequestMapping("/")
    @ResponseBody
    public String helloWord() {
        return "Hello World!";
    }
}
