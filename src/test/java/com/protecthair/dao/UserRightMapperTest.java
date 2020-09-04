package com.protecthair.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author by liuquan
 * @Classname UserRightMapperTest
 * @Description TODO
 * @Date 2020/9/2 15:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserRightMapperTest extends TestCase {

    @Autowired
    UserRightMapper userRightMapper;

    @Test
    public void testInsertUserRightWithUsers() {
        System.out.println( userRightMapper.insertUserRightWithUsers(38));
    }
}