package com.wpca.security.Handler;

import cn.hutool.json.JSONUtil;
import com.wpca.common.lang.Result;
import com.wpca.ultis.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.markhub.security.JwtLogoutSuccessHandler
 * @Date 2022年07月17日 17:08
 * @Description
 */

@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }


        response.setContentType("applicaiton/json;charset=UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();


        String jwt= jwtUtils.generateToken(authentication.getName());
        response.setHeader(jwtUtils.getHeader(),"");//清空token

        Result result = Result.succ("");

        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));


        outputStream.flush();
        outputStream.close();
    }
}
