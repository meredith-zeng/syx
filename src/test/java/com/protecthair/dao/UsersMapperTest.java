package com.protecthair.dao;

import com.protecthair.domain.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author by liuquan
 * @Classname UsersMapperTest
 * @Description TODO
 * @Date 2020/8/31 16:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UsersMapperTest extends TestCase {

    @Autowired
    UsersMapper usersMapper;

    @Test
    public void testSelectByUniversityCode() {
        System.out.println(usersMapper.selectByUniversityCode("20190001"));
    }

    @Test
    public void testModifyUserMsg() {
        User user = new User(38,"13062332215");
        usersMapper.modifyUserMsg(user);
    }


    @Test
    public void testSetNewPassword() {
        User user = new User();
        user.setUniversityCode("20190001");
        user.setUserPassword("121321wsw12");
        usersMapper.setNewPassword(user);
    }
}