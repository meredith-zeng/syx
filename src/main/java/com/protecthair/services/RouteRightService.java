package com.protecthair.services;

import com.protecthair.vo.RouteRightVO;

import java.util.Collection;

public interface RouteRightService {
    Collection<RouteRightVO> queryRouteRight(int rightLevel);
}
