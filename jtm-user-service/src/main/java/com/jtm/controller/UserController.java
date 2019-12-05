package com.jtm.controller;

import com.jtm.dto.JBMatch;
import com.jtm.mapper.JBMatchDao;
import com.jtm.mapper.JBMatchMapper;
import com.jtm.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private JBMatchDao jBMatchDao;
	@Autowired
	private JBMatchMapper jbMatchMapper;

	// 压力测试游标
	int a = 0;

	@RequestMapping("/query")
	@ResponseBody
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

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request,HttpServletResponse response){
		// 生产session，存入cookie
		HttpSession session = request.getSession();
		// 获取session的Id
		String sessionId = session.getId();
		Cookie cookie = new Cookie("sessionId",sessionId);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		String name = request.getParameter("name");
		// 将用户名和session一对一关联
		ServletContext application=session.getServletContext();
//		application.setAttribute(sessionId,name);
		application.setAttribute(name,sessionId);

		Map<String,String> map = new HashMap<String,String>();
		map.put("message","登录成功！");
		return "登录成功!";
	}

	@RequestMapping("/getCookie")
	@ResponseBody
	public Map getCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		Map<String,String> map = new HashMap<String,String>();
		if(cookies != null){
			for(Cookie cookie:cookies){
				map.put(cookie.getName(),cookie.getValue());
			}
		}
		return map;
	}

	@RequestMapping("/getSession")
	@ResponseBody
	public String getSession(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		session.setAttribute("data", "孤傲苍狼");
		//获取session的Id
		String sessionId = session.getId();
		//判断session是不是新创建的
		if (session.isNew()) {
			return  "session创建成功，session的id是："+sessionId;
		}else {
			return  "服务器已经存在该session了，session的id是："+sessionId;
		}
	}

	@RequestMapping("/send")
	@ResponseBody
	public Map send(HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		HttpSession session = request.getSession();
		String sessionid = session.getId();
		String message = request.getParameter("message");
		String name = request.getParameter("name1");
		// 判断是否存在用户
		ServletContext context = session.getServletContext();
		String receiptSessionId = (String) context.getAttribute(name);
		if(receiptSessionId == null || "".equals(receiptSessionId)){
			map.put("flag","0");
			map.put("message","不存在该用户!");
			return map;
		}
		// 消息存入application
		context.setAttribute(receiptSessionId,message);
		map.put("flag","1");
		map.put("message","发送成功");
		return map;
	}

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
