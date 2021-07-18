package com.kss.jt.web.controller;

import com.kss.jt.domain.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class AuthController {
    @PostMapping("login")
    public JsonResult doLogin(String username , String password){
        System.out.println(username+"/"+password);
        return new JsonResult("login ok !");
    }
}
