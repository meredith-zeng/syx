package com.protecthair.dao;

import com.protecthair.domain.RouteRight;

import java.util.List;

public interface RouteRightMapper {
    int insert(RouteRight record);

    int insertSelective(RouteRight record);

    List<RouteRight> queryRouteRight(int rightLevel);
}