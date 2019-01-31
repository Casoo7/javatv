package com.jtm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtm.util.CalUtils;

@RestController
public class QueryController {
	@RequestMapping("/query")
	public String hi(){
		CalUtils cal = new CalUtils();
		return cal.MergeDateOrderByDesc();
	}
}
