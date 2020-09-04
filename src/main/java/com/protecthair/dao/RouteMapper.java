package com.protecthair.dao;

import com.protecthair.domain.Route;

public interface RouteMapper {
    int deleteByPrimaryKey(Integer routeCode);

    int insert(Route record);

    int insertSelective(Route record);

    Route selectByPrimaryKey(Integer routeCode);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);
}