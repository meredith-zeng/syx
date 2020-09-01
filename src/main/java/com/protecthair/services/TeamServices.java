package com.protecthair.services;

import com.protecthair.VO.TeamApplyVO;
import com.protecthair.VO.TeamReviewVO;
import com.protecthair.domain.SessionUser;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author by liuquan
 * @Classname TeamServices
 * @Description TODO
 * @Date 2020/8/29 16:27
 */
public interface TeamServices {
    CodeMsg applyTeam(String stuId, TeamApplyVO teamApplyVO);

    Result getTeamApplyByStatus(String status);

    Result getMyTeamApply(String stuId);

    CodeMsg reviewTeam(TeamReviewVO teamApplyVO);

}
