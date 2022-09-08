package com.wpca.security.Handler;

import cn.hutool.json.JSONUtil;

import com.wpca.common.lang.Result;
import com.wpca.ultis.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.markhub.security.LoginSuccessHandler
 * @Date 2022年07月15日 14:53
 * @Description
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setContentType("applicaiton/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();

        String jwt= jwtUtils.generateToken(authentication.getName());
        response.setHeader(jwtUtils.getHeader(),jwt);


        Result result = Result.succ("登入成功");

        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));


        outputStream.flush();
        outputStream.close();
    }


}
