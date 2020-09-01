package com.protecthair.vo;

import com.protecthair.domain.RouteRight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName RouteRightVO
 * @Description TODO
 * @Author lenovo
 * @Date 2020/8/24 11:03
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteRightVO {
    private String ListParentName;
    private List<RouteRight> childPartList;

}
