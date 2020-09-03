package com.protecthair.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author by liuquan
 * @Classname TeamApply
 * @Description TODO
 * @Date 2020/8/29 16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamApply {
    private Integer certificationId;
    private Integer teamId;
    private String teamName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date activityBeginTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date activityEndTime;
    private String teamLevel;
    private String isPass;
    private String certificationFileUrl;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date certificationTime;

    public TeamApply(int i, Date date, Date date1, String s1,  String s) {
        this.setTeamId(i);
        this.setActivityBeginTime(date);
        this.setActivityEndTime(date1);
        this.setIsPass(s1);
        //this.setCreatedTime(date2);
        this.setCertificationFileUrl(s);
    }

    public TeamApply(int i, String s, String s1, Date date) {
        this.setTeamId(i);
        this.setTeamLevel(s);
        this.setIsPass(s1);
        this.setCertificationTime(date);
    }

    public TeamApply(Integer teamID) {
        this.teamId = teamID;
    }
}
