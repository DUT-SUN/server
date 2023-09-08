package com.kemi.actable.config;
import com.kemi.actable.common.AjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 功能描述
 * 实现统一数据返回的保底类
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/13  17:49
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }
/**
* @explain 对数据格式进行校验和封装返回
* @param body
* @param returnType
* @param selectedContentType
* @param selectedConverterType
* @param request
* @param response
* @return java.lang.Object
* @author DUT-SUN
* @date   2023/4/13
*/
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof AjaxResult)
        {
            return body;
        }
        if(body instanceof String){
                return objectMapper.writeValueAsString(AjaxResult.success(body));
        }
        return AjaxResult.success(body);
    }
}
