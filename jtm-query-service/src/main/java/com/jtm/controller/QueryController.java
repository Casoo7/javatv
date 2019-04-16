package com.jtm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtm.dto.JBMatch;
import com.jtm.mapper.JBMatchMapper;
import com.jtm.util.CalUtils;
import com.jtm.util.DateUtil;

@RestController
public class QueryController {
	private JBMatchMapper jbMatchMapper;
	
	@RequestMapping("/query")
	public String hi(){
		JBMatch jbMatch = new JBMatch();
		jbMatch.setBuleteam("team1");
		jbMatch.setRedteam("team2");
		jbMatch.setMaketime(DateUtil.getCurrentDate());
		jbMatch.setModifytime(DateUtil.getCurrentDate());
		jbMatchMapper.insert(jbMatch);
		CalUtils cal = new CalUtils();
		return cal.MergeDateOrderByDesc();
	}
}
