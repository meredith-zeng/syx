package com.protecthair.domain;

public class UserRightLevel {
    private String rightLevel;

    private String rightName;

    public UserRightLevel(String rightLevel, String rightName) {
        this.rightLevel = rightLevel;
        this.rightName = rightName;
    }

    public UserRightLevel() {
        super();
    }

    public String getRightLevel() {
        return rightLevel;
    }

    public void setRightLevel(String rightLevel) {
        this.rightLevel = rightLevel == null ? null : rightLevel.trim();
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }
}