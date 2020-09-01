package com.protecthair.services.impl;

import com.protecthair.dao.RouteRightMapper;
import com.protecthair.domain.RouteRight;
import com.protecthair.services.RouteRightService;
import com.protecthair.vo.RouteRightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName RouteRightServiceImp
 * @Description TODO
 * @Author lenovo
 * @Date 2020/8/24 11:07
 * @Version 1.0
 */
@Service
public class RouteRightServiceImp implements RouteRightService {
    @Autowired
    RouteRightMapper routeRightMapper;

    @Override
    public Collection<RouteRightVO> queryRouteRight(int rightLevel)  {
        List<RouteRight> routeRightResult = routeRightMapper.queryRouteRight(rightLevel);
        //组装routeRightResult成对应的结构
        Map<Integer, RouteRightVO> finalMapResult = new HashMap<>();
        for(RouteRight x : routeRightResult){
            RouteRightVO routeRightVO = finalMapResult.get( x.getParentRouteCode());
            if( null == routeRightVO ){
                routeRightVO = new RouteRightVO();
                routeRightVO.setListParentName(x.getParentRouteName());
                List<RouteRight> routeRights = new ArrayList<>();
                routeRights.add(x);
                routeRightVO.setChildPartList( routeRights );
                finalMapResult.put(x.getParentRouteCode(), routeRightVO);
            } else {
                routeRightVO.getChildPartList().add(x);
            }
        }
        return finalMapResult.values();

    }
}
