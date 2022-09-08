package com.wpca.security.Handler;

import cn.hutool.json.JSONUtil;
import com.wpca.common.lang.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.markhub.security.JwtAccessDeniedHandler
 * @Date 2022年07月16日 16:35
 * @Description  权限不足 处理器
 */
@Component
public class JwtAccessDeniedHandler  implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        //设置相应类型
        response.setContentType("applicaiton/json;charset=UTF-8");


        //设置相应状态为403 权限不足
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); //403
        ServletOutputStream outputStream = response.getOutputStream();


        //发送权限不足信息 将result写入到响应当中
        Result result = Result.fail(accessDeniedException.getMessage());
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));


        //关闭流
        outputStream.flush();
        outputStream.close();
    }
}
