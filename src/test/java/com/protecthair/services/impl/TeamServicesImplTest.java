package com.protecthair.services.impl;

import com.protecthair.VO.TeamApplyVO;
import com.protecthair.VO.TeamReviewVO;
import com.protecthair.dao.TeamMapper;
import com.protecthair.domain.TeamApply;
import com.protecthair.services.TeamServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author by liuquan
 * @Classname TeamServicesImplTest
 * @Description TODO
 * @Date 2020/8/31 16:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml",
        "classpath:spring-mybatis.xml"})
public class TeamServicesImplTest {

    @Autowired
    TeamMapper mapper;

    @Autowired
    TeamServicesImpl teamServices;

    @Test
    public void applyTeam() {
        String stuId = "20190003";
        TeamApplyVO teamApplyVO = new TeamApplyVO();
        teamApplyVO.setTeamId(1);
        teamApplyVO.setActivityBeginTime(new Date());
        teamApplyVO.setActivityEndTime(new Date());
        String path = "file/wq/qws/.dlf";
        teamApplyVO.setCertificationFileUrl(path);
        teamServices.applyTeam(stuId,teamApplyVO);
    }

    @Test
    public void getTeamApplyByStatus() {
        teamServices.getTeamApplyByStatus("未审核");
    }

    @Test
    public void getMyTeamApply() {
        teamServices.getMyTeamApply("20190002");
    }

    @Test
    public void reviewTeam() {
        TeamReviewVO teamReviewVO = new TeamReviewVO();
        teamReviewVO.setCertificationId(14);
        teamReviewVO.setIsPass("审核通过");
        teamReviewVO.setTeamLevel("校级团队");
        teamServices.reviewTeam(teamReviewVO);
    }
}