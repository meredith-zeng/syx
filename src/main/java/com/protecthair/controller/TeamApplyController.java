package com.protecthair.controller;

import com.protecthair.vo.TeamApplyVO;
import com.protecthair.vo.TeamReviewVO;
import com.protecthair.domain.SessionUser;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.services.TeamApplyServices;
import com.protecthair.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author by liuquan
 * @Classname TeamApplyController
 * @Description TODO
 * @Date 2020/8/29 16:17
 */
@RestController
@RequestMapping(path = "/api/team")
public class TeamApplyController {

    @Autowired
    TeamApplyServices teamApplyServices;

    //学生团队申请
    @RequestMapping(value = "/apply")
    public Result teamApply(@RequestParam("file") MultipartFile picture,
                            @Validated TeamApplyVO teamApplyVO, BindingResult res,
                            HttpServletRequest request) throws IOException {
        if (res.hasErrors()){
            return Result.CodeMsg(CodeMsg.NULL_DATA);
        }
        //获取团队号,查看目前登录的人是否创建了团队
        SessionUser sessionUser = SessionUtil.getSessionUserFromCookie(request);
        String stuId = sessionUser.getUser().getUniversityCode();
        // 判断文件是否为空
        if (picture.isEmpty()) {
            return Result.CodeMsg(CodeMsg.SUBMIT_APPROVAL_ERROR);
        }
        //获得物理路径webapp所在路径
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path = "";
        //获得文件类型（可以判断如果不是pdf，禁止上传）
        String contentType = picture.getContentType();
        if (contentType.equals("application/pdf") && !picture.isEmpty()) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "/file/" + uuid + "." + imageName;
            picture.transferTo(new File(pathRoot + path));
        } else {
            return Result.CodeMsg(CodeMsg.SUBMIT_FILE_ERROR);
        }
        teamApplyVO.setCertificationFileUrl(path);
        CodeMsg codeMsg = teamApplyServices.applyTeam(stuId, teamApplyVO);
        return Result.CodeMsg(codeMsg);
    }

    //学生根据学号获取
    @RequestMapping(value = "/applyByMyself", method = RequestMethod.POST)
    public Result getMyTeamApply(HttpServletRequest request) {
        SessionUser sessionUser = SessionUtil.getSessionUserFromCookie(request);
        String stuId = sessionUser.getUser().getUniversityCode();
        Result result = teamApplyServices.getMyTeamApply(stuId);
        return result;
    }

    //管理员根据状态获取
    @RequestMapping(value = "/applyByStatus", method = RequestMethod.POST)
    public Result getTeamApplyByStatus(@Validated @RequestParam("applyStatus") String status) {
        Result result = teamApplyServices.getTeamApplyByStatus(status);
        return result;
    }

    //管理员进行审核
    @RequestMapping(value = "/review")
    public Result teamReview(@Validated TeamReviewVO teamApplyVO) {
        CodeMsg codeMsg = teamApplyServices.reviewTeam(teamApplyVO);
        return Result.CodeMsg(codeMsg);
    }
}
