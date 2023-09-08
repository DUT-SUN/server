package com.kemi.actable.common;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * 功能描述:统一数据格式返回
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/13  17:38
 */
@RestController
@Data
public class AjaxResult implements Serializable {
    //状态码
    private Integer code;
    //状态码描述信息
    private String msg;
    //返回的数据
    private Object data;



    public static AjaxResult success(Object data){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.setCode(200);
        ajaxResult.setMsg("成功");
        ajaxResult.setData(data);
        return ajaxResult;
    }
    public static AjaxResult success(Integer code,Object data){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setMsg("成功");
        ajaxResult.setData(data);
        return ajaxResult;
    }
    public static AjaxResult success(Integer code,String msg,Object data){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setMsg(msg);
        ajaxResult.setData(data);
        return ajaxResult;
    }
    public static AjaxResult fail(int code,String msg){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }
}
