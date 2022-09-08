package com.wpca.security.filter;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wpca.common.exception.CaptchaException;
import com.wpca.common.lang.Const;
import com.wpca.security.Handler.LoginFailureHandler;
import com.wpca.ultis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.wpca.security.CaptchaFilter
 * @Date 2022年07月15日 16:40
 * @Description  验证是否是登入请求，如果是判断验证码是否正确，正确的话通过过滤器
 */
@Slf4j
@Component//注意 这里 的 是一个Component的一个组件
public class CaptchaFilter extends OncePerRequestFilter {


    //这里 进行注入 redis工具类 接下来 需要 对验证码 进行一些 查找 的一个操作
    @Autowired
    RedisUtil redisUtil;

    //异常处理器
    @Autowired
    LoginFailureHandler loginFailureHandler;

    private final String loginUrl = "/login";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


        //获取请求的URL
        String url= request.getRequestURI();


        //判断是否是登入请求并且是通过POST放方法进入
        if(loginUrl.equals(url)&& request.getMethod().equals("POST"))
        {
            //校验验证码
            log.info("doFilterInternal过滤器拦截并获取到login链接，正在校验验证码，请求的url为：" + url);
            try {
                //校验成功
                validate(request);
            } catch (CaptchaException e) {
                log.info("验证码与Redis中关联验证失败，可能是RedisKey已经被使用,验证码过期，或验证码错误。异常信息："+e.getMessage());

                //将验证失败的处理交给 登入失败的处理器
                loginFailureHandler.onAuthenticationFailure(request,response,e);
            }
        }



        filterChain.doFilter(request,response);
        //do nothing
    }

    private void validate(HttpServletRequest request) {
        //获取验证码 和 reids 的 key值

        String code= request.getParameter("code");

        String redisKey  = request.getParameter("redisKey");
        log.info("当前用户的验证码为:"+code);
        log.info("当前用户的redisKey为:"+redisKey);

        // 这里如果 两个其中有一个是空的字符串 则抛出异常
        if(StringUtils.isBlank(code)||StringUtils.isBlank(redisKey)){
            log.info("验证码为空");
            throw new CaptchaException("验证码为空");
        }

        // 如果 验证码 匹配 不正确 则也是 抛出验证码 异常
        if(!code.equals(redisUtil.hget(Const.captcha_KEY,redisKey))){

            log.info("验证码错误");
            throw new CaptchaException("验证码错误");//没有匹配

        }


        //保证验证码 一次性使用
        //校验完一次后 将redis里面的原来的验证码 进行删除 防止暴力破解验证码
        redisUtil.hdel(Const.captcha_KEY,redisKey);


    }
}
