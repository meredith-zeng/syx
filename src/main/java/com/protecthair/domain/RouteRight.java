package com.protecthair.domain;

public class RouteRight {
    private String routeCode;

    private String routeParentCode;

    private String rightLevel;

    public RouteRight(String routeCode, String routeParentCode, String rightLevel) {
        this.routeCode = routeCode;
        this.routeParentCode = routeParentCode;
        this.rightLevel = rightLevel;
    }

    public RouteRight() {
        super();
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode == null ? null : routeCode.trim();
    }

    public String getRouteParentCode() {
        return routeParentCode;
    }

    public void setRouteParentCode(String routeParentCode) {
        this.routeParentCode = routeParentCode == null ? null : routeParentCode.trim();
    }

    public String getRightLevel() {
        return rightLevel;
    }

    public void setRightLevel(String rightLevel) {
        this.rightLevel = rightLevel == null ? null : rightLevel.trim();
    }
}