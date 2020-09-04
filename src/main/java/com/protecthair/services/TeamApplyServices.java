package com.protecthair.services;

import com.protecthair.vo.TeamApplyVO;
import com.protecthair.vo.TeamReviewVO;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;

/**
 * @author by liuquan
 * @Classname TeamServices
 * @Description TODO
 * @Date 2020/8/29 16:27
 */
public interface TeamApplyServices {
    CodeMsg applyTeam(String stuId, TeamApplyVO teamApplyVO);

    Result getTeamApplyByStatus(String status);

    Result getMyTeamApply(String stuId);

    CodeMsg reviewTeam(TeamReviewVO teamApplyVO);

}
