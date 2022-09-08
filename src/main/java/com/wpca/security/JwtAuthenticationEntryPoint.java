package com.wpca.security;

import cn.hutool.json.JSONUtil;
import com.wpca.common.lang.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.security.JwtAuthenticationEntryPoint
 * @Date 2022年07月16日 16:34
 * @Description 401异常
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {


        response.setContentType("applicaiton/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401 未登入直接访问


        ServletOutputStream outputStream = response.getOutputStream();

        Result result = Result.fail("请先登入");
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));


        outputStream.flush();
        outputStream.close();
    }
}
