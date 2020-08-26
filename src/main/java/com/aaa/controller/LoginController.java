package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WH
 * @date 2020/8/26 16:10
 */
@Controller
@RequestMapping("/L")
public class LoginController {

    @RequestMapping("/login")
    public String reLogin(){
        return "login";
    }
}
