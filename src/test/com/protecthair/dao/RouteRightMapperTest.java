package com.protecthair.dao;

import com.protecthair.domain.RouteRight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RouteRightMapperTest {
    @Autowired
    RouteRightMapper routeRightMapper;
    @Test
    public void queryRouteRight() {
        List<RouteRight> queryRouteRightResult =  routeRightMapper.queryRouteRight(100);
        for (RouteRight x : queryRouteRightResult){
            System.out.println(x.getRouteName()+" "+x.getRouteCode() +" "+x.getRouteUrl());
        }

    }
}