package com.jtm.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/match", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MatchController {

    @RequestMapping("/match")
    public Map<String,String> test(){
        Map map = new HashMap<String,String>();
        map.put("name","we");
        map.put("mobile","123456789");
        map.put("email","iadfdasfasdg@qq.com");
        return map;
    }
}
