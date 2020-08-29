package com.protecthair.services.impl;

import com.protecthair.domain.Log;
import com.protecthair.services.LogServices;
import com.protecthair.vo.LogVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class LogServiceImplTest {
        @Autowired
        LogServices logServices;

    @Test
    public void insertLog() {
        LogVO logVO = new LogVO();
        logVO.setTeamName("保住头发");
        logVO.setTeamId(4);
        logVO.setLogSpecific("昨天也是这样的呢");

        System.out.println(logServices.insertLog(logVO));
    }

    @Test
    public void updateLog() {
        LogVO logVO = new LogVO();
        logVO.setLogSpecific("是的呢");
        logVO.setLogCode(7);

        System.out.println(logServices.updateLog(logVO));
    }

    @Test
    public void selectLog() {
        System.out.println(logServices.selectLog(7));
    }

    @Test
    public void queryTeamLog() {
        System.out.println(logServices.queryTeamLog(4));
    }

    @Test
    public void queryAll() {
        System.out.println(logServices.queryAll().size());
    }
}