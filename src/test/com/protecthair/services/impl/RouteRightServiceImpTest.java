package com.protecthair.services.impl;

import com.protecthair.dao.RouteRightMapper;
import com.protecthair.domain.RouteRight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RouteRightServiceImpTest {
    @Autowired
    RouteRightService routeRightService;

    @Test
    public void queryRouteRight() {
        int rightLevel = 100;
        Collection<RouteRightVO> finalResult = routeRightService.queryRouteRight(rightLevel);
        for (RouteRightVO routeRightVO: finalResult){
            System.out.println(routeRightVO.getChildPartList()
                    +" "+ routeRightVO.getListParentName());
        }

    }
}