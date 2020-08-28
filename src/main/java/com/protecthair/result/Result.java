package com.protecthair.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by liuquan
 * @Classname com.com.protecthair.result.Result
 * @Description 返回统一格式的结果
 * @Date 2020/8/10 12:59
 */
@Data
@AllArgsConstructor
public class Result<T> {
    //状态码
    private int code;
    //信息
    private String msg;
    //data
    private T data;

    //success
    private Result(T data,CodeMsg msg) {
        this.code = msg.getCode();
        this.msg = msg.getMsg();
        this.data = data;
    }
    //error
    private Result(CodeMsg cm) {
        if(cm==null) {
            return;
        }
        this.code=cm.getCode();
        this.msg=cm.getMsg();
    }

    //成功
    public static  Result CodeMsg(CodeMsg msg){
        return new Result(msg) ;
    }


    //成功
    public static <T> Result<T> success(T data,CodeMsg msg){
        return new Result<T>(data,msg) ;
    }

    // 失败
    public static <T> Result<T> error(CodeMsg sm) {
        return new Result<T>(sm);
    }
}
