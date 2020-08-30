package com.protecthair.domain;

public class Users {
    private String user;

    private Long currentConnections;

    private Long totalConnections;

    public Users(String user, Long currentConnections, Long totalConnections) {
        this.user = user;
        this.currentConnections = currentConnections;
        this.totalConnections = totalConnections;
    }

    public Users() {
        super();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Long getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(Long currentConnections) {
        this.currentConnections = currentConnections;
    }

    public Long getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(Long totalConnections) {
        this.totalConnections = totalConnections;
    }
}