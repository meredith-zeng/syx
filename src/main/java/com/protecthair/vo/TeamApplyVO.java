package com.protecthair.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
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
    private String teamName;

    @NotNull
    @Future(message = "需要一个将来日期") // 只能是将来的日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityBeginTime;

    @NotNull
    @Future(message = "需要一个将来日期") // 只能是将来的日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityEndTime;

    private String certificationFileUrl;
}
