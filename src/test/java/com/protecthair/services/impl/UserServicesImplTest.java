package com.protecthair.services.impl;

import com.protecthair.VO.LoginVo;
import com.protecthair.VO.ModifyPasswordVO;
import com.protecthair.VO.ModifyVO;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author by liuquan
 * @Classname UserServicesImplTest
 * @Description TODO
 * @Date 2020/8/31 16:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml",
        "classpath:spring-mybatis.xml"})
public class UserServicesImplTest {

    @Autowired
    UserServices userServices;

    @Test
    public void login() {
        LoginVo loginVo = new LoginVo();
        loginVo.setUniversityCode("20190003");
        loginVo.setUserPassword("123456");
        Result result = userServices.login(loginVo);
        System.out.println(result);
    }

    @Test
    public void modifyUser() {
        ModifyVO modifyVO = new ModifyVO();
        modifyVO.setUserId(41);
        modifyVO.setUserPhoneNumber("12321414");
        userServices.modifyUser(modifyVO);
    }


    @Test
    public void modifyUserPassword() {
        ModifyPasswordVO modifyPasswordVO = new ModifyPasswordVO();
        modifyPasswordVO.setMsgCode(1111);
        modifyPasswordVO.setNewPasswprd("12345678");
        modifyPasswordVO.setUserPassword("123456");
        CodeMsg rs = userServices.modifyUserPassword("20190002",modifyPasswordVO,1111);
        System.out.println(rs);
    }
}