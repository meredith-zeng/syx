package com.protecthair.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author by liuquan
 * @Classname TeamApplyVO
 * @Description TODO
 * @Date 2020/8/29 16:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamApplyVO {

    private Integer teamId;
    private Date activityBeginTime;
    private Date activityEndTime;
    private String certificationFileUrl;
}
