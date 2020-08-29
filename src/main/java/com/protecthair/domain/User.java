package com.protecthair.domain;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String avatar;

    private Date regtime;

    public User(Integer id, String name, String avatar, Date regtime) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.regtime = regtime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }
}