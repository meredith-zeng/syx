package com.protecthair.services;

import com.protecthair.domain.Log;
import com.protecthair.result.CodeMsg;
import com.protecthair.vo.LogVO;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public interface LogServices {
    //添加日志
    int insertLog (LogVO logVO) throws ParseException;
    //修改日志
    int updateLog(LogVO logVO) throws ParseException;
    //选择某一具体日志
    LogVO selectLog(int LogCode) throws ParseException;
    //查询团队所有日志
    ArrayList<LogVO> queryTeamLog(int TeamId);
    //查询所有团队的所有日志,等待团队的mapper正式定稿后在services层调用
    ArrayList<LogVO>  queryAll();
}
