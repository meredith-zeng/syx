package com.protecthair.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *  @author YULIN ZENG
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteRight {
    private int routeCode;
    private String routeName;
    private String routeLevel;
    private String routeUrl;
    private String parentRouteName;
    private int parentRouteCode;
    }
