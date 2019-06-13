package com.jtm.controller;

import com.jtm.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/match", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MatchController {

    @Autowired
    private MatchService matchService;

    @RequestMapping("/match")
    @ResponseBody
    public Map<String,String> test(){
        matchService.test();
        Map map = new HashMap<String,String>();
        map.put("name","we");
        map.put("mobile","123456789");
        map.put("email","iadfdasfasdg@qq.com");
        return map;
    }

    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.put("name","007");
        modelMap.put("id","002");
        return "index";
    }
}
