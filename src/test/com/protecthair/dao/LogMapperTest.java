package com.protecthair.dao;

import com.protecthair.domain.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class LogMapperTest {
    @Autowired
    LogMapper logMapper;

    @Test
    public void insert() {
        Log log = new Log();
        log.setLogSpecific("测试日志");
        log.setLogTeamId(2);
        int insertResult = logMapper.insertSelective(log);
        System.out.println(insertResult);
    }

    @Test
    public void selectByPrimaryKey() {
        int PrimaryKey = 4;
        Log SelectLogResult = logMapper.selectByPrimaryKey(PrimaryKey);
        System.out.println(SelectLogResult);
    }

    @Test
    public void updateByPrimaryKeySelective() {
        Log log = new Log();
        log.setLogSpecific("尽诛宵小天策义");
        log.setLogCode(5);
        int updateResult = logMapper.updateByPrimaryKeySelective(log);
        System.out.println(updateResult);
    }

    @Test
    public void queryAll() {
        List<Log> queryResult = logMapper.queryAll();
        System.out.println(queryResult.size());
    }
}