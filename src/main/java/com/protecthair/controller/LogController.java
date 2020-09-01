package com.protecthair.controller;

import com.protecthair.domain.SessionUser;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.services.LogServices;
import com.protecthair.util.SessionUtil;
import com.protecthair.vo.LogVO;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/8/29 15:33
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/log")
public class LogController {
    private LogServices logServices;
    @Autowired
    public void setLogController(LogServices logServices){
        this.logServices=logServices;
    }

    //添加日志
    @ResponseBody
    @RequestMapping(value = "/insertLog",method = RequestMethod.POST)
    public Result insertLog(@RequestBody LogVO logVO,HttpServletRequest request) throws ParseException {
        SessionUser session  = SessionUtil.getSessionUserFromCookie(request);
        int TeamId = session.getTeamId();
        logVO.setTeamId(TeamId);
        if (logServices.insertLog(logVO)==1){
            return Result.success(true,CodeMsg.LOG_INSERT_SUCCESS);
        }else{
            return Result.error(CodeMsg.LOG_INSERT_ERROR);
        }
    }

    //    修改日志
    @ResponseBody
    @RequestMapping(value = "/updateLog",method = RequestMethod.POST)
    public Result updateLog(@RequestBody LogVO logVO,HttpServletRequest request) throws ParseException {
        SessionUser session  = SessionUtil.getSessionUserFromCookie(request);
        int TeamId = session.getTeamId();
        logVO.setTeamId(TeamId);
        if (logServices.updateLog(logVO)==1){
            return Result.success(true,CodeMsg.LOG_UPDATE_SUCCESS);
        }else{
            return Result.error(CodeMsg.LOG_UPDATE_ERROR);
        }
    }

    //选择某一具体日志
    @ResponseBody
    @RequestMapping(value = "/selectLog",method = RequestMethod.POST)
    public Result selectLog(@RequestBody LogVO logVO) throws ParseException {
        LogVO selectResult = logServices.selectLog(logVO.getLogCode());
        if (selectResult!=null){
            return Result.success(selectResult,CodeMsg.LOG_SELECT_SUCCESS);
        }else{
            return Result.error(CodeMsg.LOG_SELECT_ERROR);
        }
    }

    //查询团队所有日志
    @ResponseBody
    @RequestMapping(value = "/queryTeamLog",method = RequestMethod.GET)
    public Result queryTeamLog(HttpServletRequest request){
        SessionUser session  = SessionUtil.getSessionUserFromCookie(request);
        int TeamId = session.getTeamId();
        ArrayList<LogVO> logResult = logServices.queryTeamLog(TeamId);
        if (logResult!=null){
            return Result.success(logResult,CodeMsg.LOG_SELECT_ALL_SUCCESS);
        }else{
            return Result.error(CodeMsg.LOG_SELECT_ALL_ERROR);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    public Result queryAll(){
        ArrayList<LogVO> logResult = logServices.queryAll();
        if (logResult!=null){
            return Result.success(logResult,CodeMsg.LOG_QUERY_SUCCESS);
        }else{
            return Result.error(CodeMsg.LOG_QUERY_ERROR);
        }
    }
}