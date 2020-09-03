package com.protecthair.controller;

import com.protecthair.domain.SessionUser;
import com.protecthair.result.CodeMsg;
import com.protecthair.result.Result;
import com.protecthair.services.LogServices;
import com.protecthair.services.RouteRightService;
import com.protecthair.util.SessionUtil;
import com.protecthair.vo.RouteRightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @ClassName RouteRightController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/8/24 13:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/api/route")
public class RouteRightController {
    private RouteRightService routeRightService;
    @Autowired
    public void setRouteRightServiceController(RouteRightService routeRightService){
        this.routeRightService=routeRightService;
    }

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Result routeRight(HttpServletRequest request)  {
        SessionUser session  = SessionUtil.getSessionUserFromCookie(request);
        int UserRight = session.getUserRight().getRightLevel();
        Collection<RouteRightVO> finalMapResult = routeRightService.queryRouteRight(UserRight);
        if (finalMapResult !=null){
        return Result.success(finalMapResult, CodeMsg.RIGHT_ROUTE_SUCCESS);
        }else {
            return Result.error(CodeMsg.RIGHT_ROUTE_ERROR);
        }
    }

}
