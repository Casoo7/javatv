package com.jtm.controller;

import com.jtm.mapper.JBMatchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtm.dto.JBMatch;
import com.jtm.mapper.JBMatchMapper;
import com.jtm.util.CalUtils;
import com.jtm.util.DateUtil;

@RestController
public class QueryController {
	@Autowired
	private JBMatchDao jBMatchDao;
	@Autowired
	private JBMatchMapper jbMatchMapper;
	
	@RequestMapping("/query")
	public String hi(){
		System.out.println("测试！！！！！");
		JBMatch jbMatch = new JBMatch();
		jbMatch.setBuleteam("JDG");
		jbMatch.setRedteam("IG");
		jbMatch.setMaketime(DateUtil.getCurrentDate());
		jbMatch.setModifytime(DateUtil.getCurrentDate());
		jbMatchMapper.insert(jbMatch);
		return jBMatchDao.findNameById("1");
	}
}
