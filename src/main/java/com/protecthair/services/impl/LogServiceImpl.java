package com.protecthair.services.impl;

import com.protecthair.dao.LogMapper;
import com.protecthair.dao.TeamMapper;
import com.protecthair.domain.Log;
import com.protecthair.domain.Team;
import com.protecthair.services.LogServices;
import com.protecthair.vo.LogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.DuplicateKeyException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    LogMapper logMapper;
    @Autowired
    TeamMapper teamMapper;

    @Override
    public int insertLog(LogVO logVO) throws ParseException {
        Log log = new Log();
        log.setLogSpecific(logVO.getLogSpecific());
        log.setLogTeamId(logVO.getTeamId());
        String logTime = logVO.getLogTime();
        Date dateResult =
                new SimpleDateFormat("yyyy-MM-dd").parse(logTime);
        log.setLogTime(dateResult);
        //数据库中设置insert ignore into,唯一索引插入失败直接不插入，返回结果为0
        return logMapper.insertSelective(log);
    }

    @Override
    public int updateLog(LogVO logVO) throws ParseException {
        Log log = new Log();
        log.setLogSpecific(logVO.getLogSpecific());
        log.setLogCode(logVO.getLogCode());
        Date dateResult =
                new SimpleDateFormat("yyyy-MM-dd").parse(logVO.getLogTime());
        log.setLogTime(dateResult);
        return logMapper.updateByPrimaryKeySelective(log);
    }

    @Override
    public LogVO selectLog(int LogCode) throws ParseException {
        Log selectResult = logMapper.selectByPrimaryKey(LogCode);
        LogVO logVO = new LogVO();
        Team team = teamMapper.selectByPrimaryKey(selectResult.getLogTeamId());
        if (team!=null) {
            logVO.setTeamName(team.getTeamName());
            logVO.setLogCode(LogCode);
            logVO.setLogSpecific(selectResult.getLogSpecific());
            Date dateTest = selectResult.getLogTime();
            String dateString = formatter.format(dateTest);
            logVO.setLogTime(dateString);
            logVO.setTeamId(selectResult.getLogTeamId());
        }
        return logVO;
    }

    @Override
    public ArrayList<LogVO> queryTeamLog(int TeamId) {
        List<Log> queryTeamResult = logMapper.queryTeamLog(TeamId);
        return getLogVOS(queryTeamResult);
    }

    @Override
    public ArrayList<LogVO> queryAll() {
        List<Log> queryResult = logMapper.queryAll();
        return getLogVOS(queryResult);
    }

    private ArrayList<LogVO> getLogVOS(List<Log> queryResult) {
        ArrayList<LogVO> queryAllResult = new ArrayList<>();
        for (Log x : queryResult){
            Team team = teamMapper.selectByPrimaryKey(x.getLogTeamId());
            if (team!=null){
                LogVO logVO = new LogVO();
                Date dateTest = x.getLogTime();
                String dateString = formatter.format(dateTest);
                logVO.setLogTime(dateString);

                logVO.setLogCode(x.getLogCode());
                logVO.setLogSpecific(x.getLogSpecific());
                logVO.setTeamId(x.getLogTeamId());
                logVO.setTeamName(team.getTeamName());
                logVO.setOperateTime(x.getLogOperateTime());
                queryAllResult.add(logVO);
            }
        }
        return queryAllResult;
    }
}