package com.protecthair.services.impl;

import com.protecthair.VO.TeamApplyVO;
import com.protecthair.VO.TeamReviewVO;
import com.protecthair.dao.TeamMapper;
import com.protecthair.domain.SessionUser;
import com.protecthair.domain.TeamApply;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Constant;
import com.protecthair.result.Result;
import com.protecthair.services.TeamServices;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.el.ELClass;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author by liuquan
 * @Classname TeamServicesImpl
 * @Description TODO
 * @Date 2020/8/29 16:27
 */
@Service
public class TeamServicesImpl implements TeamServices {

    @Autowired
    TeamMapper mapper;

    //团队申请
    @Override
    public CodeMsg applyTeam(String stuId, TeamApplyVO teamApplyVO) {
        //根据统一验证码查看团队是否存在
        Integer teamID = mapper.selectTeamIDByStuId(stuId);
        if (teamID == null) {
            //该学号没有注册团队
            return CodeMsg.NO_EXIST_TEAM;
        }

        TeamApply teamApply = new TeamApply(teamID);
        teamApply.setIsPass("未审核");
        teamApply.setCreatedTime(new Date());
        //teamApply.setCertificationFileUrl(path);
        //TODO 需要判断下是否正确
        BeanUtils.copyProperties(teamApplyVO, teamApply);
        //插入团队申请
        if (Constant.DATE_CHANGE_SUCCESS.equals(mapper.addTeamApply(teamApply))) {
            return CodeMsg.APPLY_TEAM_SUCCESS;
        } else {
            return CodeMsg.APPLY_TEAM_FAIL;
        }
    }

    //根据状态获取团队申请列表
    @Override
    public Result getTeamApplyByStatus(String status) {
        List<TeamApply> list = mapper.showApplyByStatus(status);
        if (list != null) {
            return Result.success(list, CodeMsg.SHOW_ALLAPPLY_SUCCESS);
        } else {
            return Result.error(CodeMsg.SHOW_ALLAPPLY_ERROR);
        }
    }

    @Override
    public Result getMyTeamApply(String stuId) {
        List<TeamApply> list = mapper.showMyApply(stuId);
        if (list != null) {
            return Result.success(list, CodeMsg.SHOW_ALLAPPLY_SUCCESS);
        } else {
            return Result.error(CodeMsg.SHOW_ALLAPPLY_ERROR);
        }
    }

    //团队申请审核
    @Override
    public CodeMsg reviewTeam(TeamReviewVO teamReviewVO) {
        TeamApply teamApply = new TeamApply();
        teamApply.setCertificationId(teamReviewVO.getCertificationId());
        teamApply.setCertificationTime(new Date());
        //转换VO对象
        BeanUtils.copyProperties(teamReviewVO, teamApply);
        if (Constant.DATE_CHANGE_SUCCESS.equals(mapper.reviewTeam(teamApply))) {
            return CodeMsg.TEAM_REVIEWS_SUCCESS;
        } else {
            return CodeMsg.TEAM_REVIEWS_ERROR;
        }
    }


}
