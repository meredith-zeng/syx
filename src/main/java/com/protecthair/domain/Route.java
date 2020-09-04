package com.protecthair.domain;

public class Route {
    private Integer routeCode;

    private String routeName;

    private String routeLevel;

    private String routeUrl;

    private Integer parentRouteCode;

    public Route(Integer routeCode, String routeName, String routeLevel, String routeUrl, Integer parentRouteCode) {
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.routeLevel = routeLevel;
        this.routeUrl = routeUrl;
        this.parentRouteCode = parentRouteCode;
    }

    public Route() {
        super();
    }

    public Integer getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(Integer routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    public String getRouteLevel() {
        return routeLevel;
    }

    public void setRouteLevel(String routeLevel) {
        this.routeLevel = routeLevel == null ? null : routeLevel.trim();
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl == null ? null : routeUrl.trim();
    }

    public Integer getParentRouteCode() {
        return parentRouteCode;
    }

    public void setParentRouteCode(Integer parentRouteCode) {
        this.parentRouteCode = parentRouteCode;
    }
}