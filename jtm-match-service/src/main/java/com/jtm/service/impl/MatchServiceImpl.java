package com.jtm.service.impl;

import com.jtm.dto.JBMatch;
import com.jtm.mapper.JBMatchMapper;
import com.jtm.service.MatchService;
import com.jtm.util.DateUtil;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchServiceImpl implements MatchService {
    public static Logger log = LoggerFactory.getLogger(MatchServiceImpl.class);

    @Autowired
    private JBMatchMapper jbMatchMapper;

    @Override
    @Transactional
    public void test() {
        log.debug("事务开始！");
        log.debug("开始插入数据！");
        JBMatch jbMatch = new JBMatch();
        jbMatch.setBuleteam("vg");
        jbMatch.setRedteam("tl");
        jbMatch.setMaketime(DateUtil.getCurrentDate());
        jbMatch.setModifytime(DateUtil.getCurrentDate());
        jbMatchMapper.insert(jbMatch);
        log.debug("插入数据结束！");
        log.debug("事务结束！");
        //throw new RuntimeException("测试报错！");
    }
}
