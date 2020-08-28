package com.protecthair.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by liuquan
 * @Classname General
 * @Description TODO
 * @Date 2020/8/12 11:21
 */
@Data
@AllArgsConstructor
public class General {
    private String msg;
    public static General NUll_Data =new General("返回数据");
}
