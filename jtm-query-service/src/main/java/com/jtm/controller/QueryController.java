package com.jtm.controller;

import com.jtm.mapper.JBMatchDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtm.dto.JBMatch;
import com.jtm.mapper.JBMatchMapper;
import com.jtm.util.CalUtils;
import com.jtm.util.DateUtil;

@RestController
public class QueryController {
	private static Logger log = LoggerFactory.getLogger(QueryController.class);
	@Autowired
	private JBMatchDao jBMatchDao;
	@Autowired
	private JBMatchMapper jbMatchMapper;

	// 压力测试游标
	int a = 0;

	@RequestMapping("/query")
	public String hi(){
		a++;
		System.out.println("测试！！！！！第"+a+"次！");
		log.debug("debug");
		log.info("info");
		log.error("error");
		log.warn("warn");
		log.trace("trace");
		JBMatch jbMatch = new JBMatch();
		jbMatch.setBuleteam("JDG");
		jbMatch.setRedteam("IG");
		jbMatch.setMaketime(DateUtil.getCurrentDate());
		jbMatch.setModifytime(DateUtil.getCurrentDate());
		jbMatchMapper.insert(jbMatch);
		return jBMatchDao.findNameById("1");
	}
}
