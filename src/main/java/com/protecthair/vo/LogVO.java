package com.protecthair.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName LogVO
 * @Description TODO
 * @Author lenovo
 * @Date 2020/8/29 10:14
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogVO {
    //日志时间
    private String logTime;
    //日志具体内容
    private String logSpecific;
    //日志编号
    private int logCode;
    //团队名称
    private String TeamName;
    //团队编号
    private int TeamId;
    //日志最后修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date operateTime;



}
