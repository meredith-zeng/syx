package com.protecthair.services.impl;

import com.protecthair.dao.LogMapper;
import com.protecthair.domain.Log;
import com.protecthair.result.CodeMsg;
import com.protecthair.services.LogServices;
import com.protecthair.vo.LogVO;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/8/29 10:18
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogServices {

    @Autowired
    LogMapper logMapper;

    @Override
    public int insertLog(LogVO logVO) {
        Log log = new Log();
        log.setLogSpecific(logVO.getLogSpecific());
        log.setLogTeamId(logVO.getTeamId());
        int insertResult = logMapper.insertSelective(log);
        return insertResult;

    }

    @Override
    public int updateLog(LogVO logVO) {
        Log log = new Log();
        log.setLogSpecific(logVO.getLogSpecific());
        int updateResult = logMapper.updateByPrimaryKeySelective(log);
        return updateResult;
    }

    @Override
    public LogVO selectLog(int LogCode) {
        Log selectResult = logMapper.selectByPrimaryKey(LogCode);
        String TeamNmae = "测试名，等待团队方法写好调用团队mapper获得teamName";

        LogVO logVO = new LogVO();
        logVO.setLogCode(LogCode);
        logVO.setLogSpecific(selectResult.getLogSpecific());
        logVO.setLogTime(selectResult.getLogOperateTime());
        logVO.setTeamId(selectResult.getLogTeamId());
        logVO.setTeamName(TeamNmae);

        return logVO;

    }

    @Override
    public ArrayList<LogVO> queryTeamLog(int TeamId) {
        String TeamName = "测试名，等待团队方法写好调用团队mapper获得teamName";

        List<Log> queryTeamResult = logMapper.queryTeamLog(TeamId);
        ArrayList<LogVO> finalQueryResult = new ArrayList<>();
        for (Log x:queryTeamResult){
            LogVO logVO = new LogVO();
            logVO.setLogTime(x.getLogOperateTime());
            logVO.setLogCode(x.getLogCode());
            logVO.setLogSpecific(x.getLogSpecific());

            logVO.setTeamName(TeamName);

            logVO.setTeamId(TeamId);
            finalQueryResult.add(logVO);
        }
        return finalQueryResult;
    }

    @Override
    public ArrayList<LogVO> queryAll() {
        return null;
    }
}
