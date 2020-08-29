package com.protecthair.services.impl;

import com.protecthair.dao.LogMapper;
import com.protecthair.dao.TeamMapper;
import com.protecthair.domain.Log;
import com.protecthair.domain.Team;
import com.protecthair.services.LogServices;
import com.protecthair.vo.LogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Autowired
    TeamMapper teamMapper;

    @Override
    public int insertLog(LogVO logVO) {
        Log log = new Log();
        log.setLogSpecific(logVO.getLogSpecific());
        log.setLogTeamId(logVO.getTeamId());
        return logMapper.insertSelective(log);

    }

    @Override
    public int updateLog(LogVO logVO) {
        Log log = new Log();
        log.setLogSpecific(logVO.getLogSpecific());
        log.setLogCode(logVO.getLogCode());
        return logMapper.updateByPrimaryKeySelective(log);
    }

    @Override
    public LogVO selectLog(int LogCode) {
        Log selectResult = logMapper.selectByPrimaryKey(LogCode);
        LogVO logVO = new LogVO();
        Team team = teamMapper.selectByPrimaryKey(selectResult.getLogTeamId());
        if (team!=null) {
            logVO.setTeamName(team.getTeamName());
            logVO.setLogCode(LogCode);
            logVO.setLogSpecific(selectResult.getLogSpecific());
            logVO.setLogTime(selectResult.getLogOperateTime());
            logVO.setTeamId(selectResult.getLogTeamId());
        }
        return logVO;
    }

    @Override
    public ArrayList<LogVO> queryTeamLog(int TeamId) {
        List<Log> queryTeamResult = logMapper.queryTeamLog(TeamId);
        ArrayList<LogVO> finalQueryResult = new ArrayList<>();
        for (Log x:queryTeamResult){
            Team team = teamMapper.selectByPrimaryKey(TeamId);
            if (team!=null){
                LogVO logVO = new LogVO();
                logVO.setLogTime(x.getLogOperateTime());
                logVO.setLogCode(x.getLogCode());
                logVO.setLogSpecific(x.getLogSpecific());
                logVO.setTeamId(TeamId);
                logVO.setTeamName(team.getTeamName());
                finalQueryResult.add(logVO);
            }
        }
        return finalQueryResult;
    }

    @Override
    public ArrayList<LogVO> queryAll() {
        List<Log> queryResult = logMapper.queryAll();
        ArrayList<LogVO> queryAllResult = new ArrayList<>();
        for (Log x : queryResult){
            Team team = teamMapper.selectByPrimaryKey(x.getLogTeamId());
            if (team!=null){
                LogVO logVO = new LogVO();
                logVO.setLogTime(x.getLogOperateTime());
                logVO.setLogCode(x.getLogCode());
                logVO.setLogSpecific(x.getLogSpecific());
                logVO.setTeamId(x.getLogTeamId());
                logVO.setTeamName(team.getTeamName());
                queryAllResult.add(logVO);
            }
        }
        return queryAllResult;
    }
}
