package com.protecthair.dao;

import com.protecthair.domain.RouteRight;

public interface RouteRightMapper {
    int insert(RouteRight record);

    int insertSelective(RouteRight record);
}