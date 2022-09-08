package com.wpca.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.wpca.common.lang.Const
 * @Date 2022年09月07日 07:10
 * @Description  存储常量
 */
@Data
public class Result implements Serializable {

    //状态码
    private int code; // 200是正常，非200表示异常

    //结果消息
    private String msg;

    //结果数据
    private Object data;


    //----------------------------成功函数--------------------------------------------------
    /**
     *
     * @methodName succ
     * @description 成功的相应

     * @param data
     * @return com.wpca.common.lang.Result
     * @CreateTime 6:21 2022/7/15
     * @UpdateTime 6:21 2022/7/15
     */

    public static Result succ(Object data) {
        return succ(200, "操作成功", data);
    }
    //自定应操作的一个函数
    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    //----------------------------失败函数-----------------------------------------------
    /**
     *
     * @methodName fail
     * @description 失败函数，返回失败的的结果

     * @param msg
     * @return com.wpca.common.lang.Result
     * @CreateTime 6:20 2022/7/15
     * @UpdateTime 6:20 2022/7/15
     */
    //无数据的的失败响应
    public static Result fail(String msg) {
        return fail(400, msg, null);
    }
    //有失败的形相应数据
    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }


    //自定义失败的编码
    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
