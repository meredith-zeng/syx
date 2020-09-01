package com.protecthair.dao;

import com.protecthair.domain.TeamApply;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author by liuquan
 * @Classname TeamMapperTest
 * @Description TODO
 * @Date 2020/8/31 14:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TeamMapperTest extends TestCase {

    @Autowired
    TeamMapper teamDao;

    @Test
    public void testSelectTeamIDByStuId() {
        Integer teamid = teamDao.selectTeamIDByStuId("20190002");
        System.out.println(teamid);
    }

    @Test
    public void testAddTeamApply() {
        TeamApply teamApply = new TeamApply(3,new Date(),new Date(),"未审核","file/xxxxx/");
        teamDao.addTeamApply(teamApply);
    }

    @Test
    public void testShowApplyByStatus() {
        System.out.println(teamDao.showApplyByStatus("未审核"));
    }

    @Test
    public void testShowMyApply() {
        System.out.println(teamDao.showMyApply("20190001"));
    }

    @Test
    public void testReviewTeam() {
        TeamApply teamApply = new TeamApply(4,"校级团队","审核通过",new Date());
        teamDao.reviewTeam(teamApply);
    }
}