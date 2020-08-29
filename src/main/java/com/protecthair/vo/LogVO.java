package com.protecthair.vo;

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
    private Date logTime;
    //日志具体内容
    private String logSpecific;
    //日志编号
    private int logCode;
    //团队名称
    private String TeamName;
    //团队编号
    private int TeamId;
}
