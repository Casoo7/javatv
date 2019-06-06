package com.jtm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MatchController {

    @RequestMapping("/match")
    public Map test(){
        Map map = new HashMap();
        map.put("name","we");
        map.put("name","omg");
        map.put("name","ig");
        return map;
    }
}
