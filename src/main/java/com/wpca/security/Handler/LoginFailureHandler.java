package com.wpca.security.Handler;

import cn.hutool.json.JSONUtil;
import com.wpca.common.lang.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.wpca.security.LoginFailureHander
 * @Date 2022年07月15日 14:51
 * @Description 登入失败处理器
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {


        //设置响应的格式
        response.setContentType("applicaiton/json;charset=UTF-8");
        //设置ServletOutputStream
        ServletOutputStream outputStream = response.getOutputStream();

        Result result = Result.fail(exception.getMessage());

        //将result写入到相应流中
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));


        outputStream.flush();
        outputStream.close();



    }
}
