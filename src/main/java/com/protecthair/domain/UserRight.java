package com.protecthair.domain;

public class UserRight {
    private String rightLevel;

    private Integer userId;

    public UserRight(String rightLevel, Integer userId) {
        this.rightLevel = rightLevel;
        this.userId = userId;
    }

    public UserRight() {
        super();
    }

    public String getRightLevel() {
        return rightLevel;
    }

    public void setRightLevel(String rightLevel) {
        this.rightLevel = rightLevel == null ? null : rightLevel.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}