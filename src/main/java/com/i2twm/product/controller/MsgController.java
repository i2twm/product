package com.i2twm.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @GetMapping("/msg")
    public String msg(){
        return "this is a msg form Product";
    }
}
