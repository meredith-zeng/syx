package com.protecthair.services.impl;

import com.protecthair.domain.Team;
import com.protecthair.vo.TeamApplyVO;
import com.protecthair.vo.TeamReviewVO;
import com.protecthair.dao.TeamApplyMapper;
import com.protecthair.domain.TeamApply;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Constant;
import com.protecthair.result.Result;
import com.protecthair.services.TeamApplyServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author by liuquan
 * @Classname TeamServicesImpl
 * @Description TODO
 * @Date 2020/8/29 16:27
 */
@Service
public class TeamApplyApplyServicesImpl implements TeamApplyServices {

    @Autowired
    TeamApplyMapper mapper;

    //团队申请
    @Override
    public CodeMsg applyTeam(String stuId, TeamApplyVO teamApplyVO) {
        //根据统一验证码查看团队是否存在
        Team teamIDByStuId = mapper.selectTeamIDByStuId(stuId);
        if (teamIDByStuId == null) {
            //该学号没有注册团队
            return CodeMsg.NO_EXIST_TEAM;
        }

        TeamApply teamApply = new TeamApply(teamIDByStuId.getTeamId());
        teamApply.setIsPass("待审核");
        teamApply.setTeamLevel("暂无");
        teamApply.setCreatedTime(new Date());
        teamApply.setTeamName(teamIDByStuId.getTeamName());
        //TODO 需要判断下是否正确
        BeanUtils.copyProperties(teamApplyVO, teamApply);
        //插入团队申请
        try {
            if (Constant.DATE_CHANGE_SUCCESS.equals(mapper.addTeamApply(teamApply))) {
                return CodeMsg.APPLY_TEAM_SUCCESS;
            } else {
                return CodeMsg.APPLY_TEAM_FAIL;
            }
        }catch (Exception e){
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
        if (list != null && list.size() != 0) {
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
        if (teamApply.getIsPass().equals("审核不通过")) {
            teamApply.setTeamLevel("无");
        }
        if (Constant.DATE_CHANGE_SUCCESS.equals(mapper.reviewTeam(teamApply))) {
            return CodeMsg.TEAM_REVIEWS_SUCCESS;
        } else {
            return CodeMsg.TEAM_REVIEWS_ERROR;
        }
    }


}
