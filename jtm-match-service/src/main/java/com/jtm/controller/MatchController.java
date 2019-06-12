package com.jtm.controller;

import com.jtm.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/match", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MatchController {

    @Autowired
    private MatchService matchService;

    @RequestMapping("/match")
    public Map<String,String> test(){
        matchService.test();
        Map map = new HashMap<String,String>();
        map.put("name","we");
        map.put("mobile","123456789");
        map.put("email","iadfdasfasdg@qq.com");
        return map;
    }
}
